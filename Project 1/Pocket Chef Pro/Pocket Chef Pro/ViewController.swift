//
//  ViewController.swift
//  Pocket Chef Pro
//
//  Created by Ari Klebanov on 10/11/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource, UITextFieldDelegate {
    
    var chipsAndQueso = Recipe()
    var fondue = Recipe()
    var chickenQuesadilla = Recipe()
    var chickenPizza = Recipe()
    var breakfastBurrito = Recipe()
    var chickenTortillaBites = Recipe()
    var firstSelected : String?
    var secondSelected : String?
    var thirdSelected : String?
    var validRecipesToDisplay : [String?] = []
    
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var ingredient1Picker: UIPickerView!
    @IBOutlet weak var ingredient2Picker: UIPickerView!
    @IBOutlet weak var ingredient3Picker: UIPickerView!
    
    @IBOutlet weak var recipe1: UIImageView!
    @IBOutlet weak var recipe2: UIImageView!
    @IBOutlet weak var recipe3: UIImageView!
    @IBOutlet weak var recipe4: UIImageView!
    @IBOutlet weak var recipe5: UIImageView!
    
    @IBOutlet weak var recipe1Label: UILabel!
    @IBOutlet weak var recipe2Label: UILabel!
    @IBOutlet weak var recipe3Label: UILabel!
    @IBOutlet weak var recipe4Label: UILabel!
    @IBOutlet weak var recipe5Label: UILabel!
    
    @IBOutlet weak var ingredient1Field: UITextField!
    @IBOutlet weak var ingredient2Field: UITextField!
    @IBOutlet weak var ingredient3Field: UITextField!
    
    @IBAction func onTapGestureRecognized(_ sender: UITapGestureRecognizer) {
        ingredient1Field.resignFirstResponder()
        ingredient2Field.resignFirstResponder()
        ingredient3Field.resignFirstResponder()
    }
    
    //the following function, lines 52-66, was pulled from a tutorial on how to use a UIPickerView as an input for a UITextField. url: https://peterwitham.com/swift-archives/how-to-use-a-uipickerview-as-input-for-a-uitextfield/
    
    let myPickerData = [String](arrayLiteral: "", "Cheddar Cheese", "Chicken Breast", "Tortillas", "Eggs", "Salsa", "Marinara Sauce", "Ranch")
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return myPickerData.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return myPickerData[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView.tag == 0{//using picker 1
            if (ingredient2Field.text?.isEmpty)! && (ingredient3Field.text?.isEmpty)!{//first entry was via picker 1//user selected ingredient 1
                firstSelected = myPickerData[row]
                updateRecipes()
                ingredient1Field.text = firstSelected
            } else if (ingredient3Field?.text?.isEmpty)! || (ingredient2Field?.text?.isEmpty)!{//second entry via picker 1, first entry in field 2 or 3
                if (ingredient3Field.text?.isEmpty)! {//first entry was in field 2
                    firstSelected = ingredient2Field.text
                } else {//first entry was in field 3
                    firstSelected = ingredient3Field.text
                }
                if row == 0{//if user selects "   " on picker
                    ingredient1Field.text = ""
                    updateRecipes()
                } else {//user selected ingredient 2
                    secondSelected = myPickerData[row]
                    updateRecipes2()
                    ingredient1Field.text = secondSelected
                }
            } else {//third entry via picker 1
                firstSelected = ingredient2Field.text
                secondSelected = ingredient3Field.text
                if row == 0{//if user selects "   " on picker
                    ingredient1Field.text = ""
                    updateRecipes2()
                } else {//user selected ingredient 3
                    thirdSelected = myPickerData[row]
                    updateRecipes3()
                    ingredient1Field.text = thirdSelected
                }
            }
        } else if pickerView.tag == 1{//using picker 2
            if (ingredient1Field.text?.isEmpty)! && (ingredient3Field.text?.isEmpty)!{//first entry was via picker 2//user selected ingredient 1
                firstSelected = myPickerData[row]
                updateRecipes()
                ingredient2Field.text = firstSelected
            } else if (ingredient3Field?.text?.isEmpty)! || (ingredient1Field?.text?.isEmpty)!{//second entry via picker 2, first entry in field 1 or 3
                if (ingredient3Field.text?.isEmpty)! {//first entry was in field 1
                    firstSelected = ingredient1Field.text
                } else {//first entry was in field 3
                    firstSelected = ingredient3Field.text
                }
                if row == 0{//if user selects "   " on picker
                    ingredient2Field.text = ""
                    updateRecipes()
                } else {//user selected ingredient 2
                    secondSelected = myPickerData[row]
                    updateRecipes2()
                    ingredient2Field.text = secondSelected
                }
            } else {//third entry via picker 2
                firstSelected = ingredient1Field.text
                secondSelected = ingredient3Field.text
                if row == 0{//if user selects "   " on picker
                    ingredient2Field.text = ""
                    updateRecipes2()
                } else {//user selected ingredient 3
                    thirdSelected = myPickerData[row]
                    updateRecipes3()
                    ingredient2Field.text = thirdSelected
                }
            }
        } else if pickerView.tag == 2{//using picker 3
            if (ingredient1Field.text?.isEmpty)! && (ingredient2Field.text?.isEmpty)!{//first entry was via picker 3//user selected ingredient 1
                firstSelected = myPickerData[row]
                updateRecipes()
                ingredient3Field.text = firstSelected
            } else if (ingredient2Field?.text?.isEmpty)! || (ingredient1Field?.text?.isEmpty)!{//second entry via picker 3, first entry in field 1 or 2
                if (ingredient1Field.text?.isEmpty)! {//first entry was in field 2
                    firstSelected = ingredient2Field.text
                } else {//first entry was in field 1
                    firstSelected = ingredient1Field.text
                }
                if row == 0{//if user selects "   " on picker
                    ingredient3Field.text = ""
                    updateRecipes()
                } else {//user selected ingredient 2
                    secondSelected = myPickerData[row]
                    updateRecipes2()
                    ingredient3Field.text = secondSelected
                }
            } else {//third entry via picker 3
                firstSelected = ingredient1Field.text
                secondSelected = ingredient2Field.text
                if row == 0{//if user selects "   " on picker
                    ingredient3Field.text = ""
                    updateRecipes2()
                } else {//user selected ingredient 3
                    thirdSelected = myPickerData[row]
                    updateRecipes3()
                    ingredient3Field.text = thirdSelected
                }
            }
        }
    }
    
//////////updateRecipes() checks every recipe to see if it contains the user-entered ingredient(s). If the recipe requires those ingredients, its name will be added to an array of 'validRecipesToDisplay', then calls updateView()
    
    func updateRecipes(){//updateRecipes adapted for 1 input
        validRecipesToDisplay = []
        if searchQueso(ingredient: firstSelected!){
            validRecipesToDisplay.append(chipsAndQueso.recipeName)
        }
        if searchFondue(ingredient: firstSelected!){
            validRecipesToDisplay.append(fondue.recipeName)
        }
        if searchQuesadilla(ingredient: firstSelected!){
            validRecipesToDisplay.append(chickenQuesadilla.recipeName)
        }
        if searchPizza(ingredient: firstSelected!){
            validRecipesToDisplay.append(chickenPizza.recipeName)
        }
        if searchBites(ingredient: firstSelected!){
            validRecipesToDisplay.append(chickenTortillaBites.recipeName)
        }
        if searchBurrito(ingredient: firstSelected!){
            validRecipesToDisplay.append(breakfastBurrito.recipeName)
        }
        updateView()
    }
    
    func updateRecipes2(){//updateRecipes adapted for 2 inputs
        validRecipesToDisplay = []
        if searchQueso(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(chipsAndQueso.recipeName)
        }
        if searchFondue(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(fondue.recipeName)
        }
        if searchQuesadilla(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(chickenQuesadilla.recipeName)
        }
        if searchPizza(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(chickenPizza.recipeName)
        }
        if searchBites(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(chickenTortillaBites.recipeName)
        }
        if searchBurrito(ingredient: firstSelected!, ingredient1: secondSelected!){
            validRecipesToDisplay.append(breakfastBurrito.recipeName)
        }
        updateView()
    }
    
    func updateRecipes3(){//updateRecipes adapted for 3 inputs
        validRecipesToDisplay = []
        if searchQueso(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(chipsAndQueso.recipeName)
        }
        if searchFondue(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(fondue.recipeName)
        }
        if searchQuesadilla(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(chickenQuesadilla.recipeName)
        }
        if searchPizza(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(chickenPizza.recipeName)
        }
        if searchBites(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(chickenTortillaBites.recipeName)
        }
        if searchBurrito(ingredient: firstSelected!, ingredient1: secondSelected!, ingredient2: thirdSelected!){
            validRecipesToDisplay.append(breakfastBurrito.recipeName)
        }
        updateView()
    }
    
    

//all images, including the logo, were found via google.com/images. I do not claim them as original content, and all rights are reserved to their creators
    func updateView() {
        recipe1.image = UIImage(named: "")
        recipe2.image = UIImage(named: "")
        recipe3.image = UIImage(named: "")
        recipe4.image = UIImage(named: "")
        recipe5.image = UIImage(named: "")
        recipe1Label.text = ""
        recipe2Label.text = ""
        recipe3Label.text = ""
        recipe4Label.text = ""
        recipe5Label.text = ""
        if let _ = validRecipesToDisplay.index(of: "Chips and Queso"){//Chips and Queso is a valid recipe
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Chips and Queso "
                recipe1.image = UIImage(named: "PCP_QuesoCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Chips and Queso "
                recipe2.image = UIImage(named: "PCP_QuesoCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Chips and Queso "
                recipe3.image = UIImage(named: "PCP_QuesoCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Chips and Queso "
                recipe4.image = UIImage(named: "PCP_QuesoCropped.jpg")
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Chips and Queso "
                recipe5.image = UIImage(named: "PCP_QuesoCropped.jpg")
            }
        }
        if let _ = validRecipesToDisplay.index(of: "Fondue"){//Fondue is a valid recipe
            
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Fondue "
                recipe1.image = UIImage(named: "PCP_FondueCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Fondue "
                recipe2.image = UIImage(named: "PCP_FondueCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Fondue "
                recipe3.image = UIImage(named: "PCP_FondueCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Fondue "
                recipe4.image = UIImage(named: "PCP_FondueCropped.jpg")
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Fondue "
                recipe5.image = UIImage(named: "PCP_FondueCropped.jpg")
            }
        }
        if let _ = validRecipesToDisplay.index(of: "Chicken Quesadilla"){//Quesadilla is a valid recipe
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Chicken Quesadilla "
                recipe1.image = UIImage(named: "PCP_QuesadillaCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Chicken Quesadilla "
                recipe2.image = UIImage(named: "PCP_QuesadillaCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Chicken Quesadilla "
                recipe3.image = UIImage(named: "PCP_QuesadillaCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Chicken Quesadilla "
                recipe4.image = UIImage(named: "PCP_QuesadillaCropped.jpg")
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Chicken Quesadilla "
                recipe5.image = UIImage(named: "PCP_QuesadillaCropped.jpg")
            }
        }
        if let _ = validRecipesToDisplay.index(of: "Chicken Pizza"){//Pizza is a valid recipe
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Chicken Pizza "
                recipe1.image = UIImage(named: "PCP_PizzaCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Chicken Pizza "
                recipe2.image = UIImage(named: "PCP_PizzaCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Chicken Pizza "
                recipe3.image = UIImage(named: "PCP_PizzaCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Chicken Pizza "
                recipe4.image = UIImage(named: "PCP_PizzaCropped.jpg")  
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Chicken Pizza "
                recipe5.image = UIImage(named: "PCP_PizzaCropped.jpg")
            }
        }
        if let _ = validRecipesToDisplay.index(of: "Chicken Tortilla Bites"){//Bites is a valid recipe
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Chicken Tortilla Bites "
                recipe1.image = UIImage(named: "PCP_TortillaBitesCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Chicken Tortilla Bites "
                recipe2.image = UIImage(named: "PCP_TortillaBitesCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Chicken Tortilla Bites "
                recipe3.image = UIImage(named: "PCP_TortillaBitesCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Chicken Tortilla Bites "
                recipe4.image = UIImage(named: "PCP_TortillaBitesCropped.jpg")
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Chicken Tortilla Bites "
                recipe5.image = UIImage(named: "PCP_TortillaBitesCropped.jpg")
            }
        }
        if let _ = validRecipesToDisplay.index(of: "Breakfast Burrito"){//Burrito is a valid recipe
            if (recipe1Label.text?.isEmpty)!{//first Recipe
                recipe1Label.text = " Breakfast Burrito "
                recipe1.image = UIImage(named: "PCP_BurritoCropped.jpg")
            }
            else if (recipe2Label.text?.isEmpty)!{//second Recipe
                recipe2Label.text = " Breakfast Burrito "
                recipe2.image = UIImage(named: "PCP_BurritoCropped.jpg")
            }
            else if (recipe3Label.text?.isEmpty)!{//third Recipe
                recipe3Label.text = " Breakfast Burrito "
                recipe3.image = UIImage(named: "PCP_BurritoCropped.jpg")
            }
            else if (recipe4Label.text?.isEmpty)!{//fourth Recipe
                recipe4Label.text = " Breakfast Burrito "
                recipe4.image = UIImage(named: "PCP_BurritoCropped.jpg")
            }
            else if (recipe5Label.text?.isEmpty)!{//fifth Recipe
                recipe5Label.text = " Breakfast Burrito "
                recipe5.image = UIImage(named: "PCP_BurritoCropped.jpg")
            }
        }
    }
    
    
    
//////////search Chips and Queso recipe for 1, 2, or 3 ingredients
    func searchQueso(ingredient: String) -> Bool{//search Queso for 1 ingredient
        if let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchQueso(ingredient : String, ingredient1 : String) -> Bool{//search Queso for 2 ingredients
        if let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient), let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchQueso(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Fondue for 3 ingredients
        if let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient), let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient1), let _ = chipsAndQueso.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }
    
//////////search Fondue recipe for 1, 2, or 3 ingredients
    func searchFondue(ingredient: String) -> Bool{
        if let _ = fondue.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchFondue(ingredient: String, ingredient1: String) -> Bool{//search Fondue for 2 ingredients
        if let _ = fondue.arrayOfIngredients?.index(of: ingredient), let _ = fondue.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchFondue(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Fondue for 3 ingredients
        if let _ = fondue.arrayOfIngredients?.index(of: ingredient), let _ = fondue.arrayOfIngredients?.index(of: ingredient1), let _ = fondue.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }

//////////search Quesadilla recipe for 1, 2, or 3 ingredients
    func searchQuesadilla(ingredient: String) -> Bool{//search Quesadilla for 1 ingredient
        if let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchQuesadilla(ingredient: String, ingredient1: String) -> Bool{//search Quesadilla for 2 ingredients
        if let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient), let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchQuesadilla(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Quesadilla for 3 ingredients
        if let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient), let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient1), let _ = chickenQuesadilla.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }
    
//////////search Pizza recipe for 1, 2, or 3 ingredients
    func searchPizza(ingredient: String) -> Bool{//search Pizza for 1 ingredient
        if let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchPizza(ingredient: String, ingredient1: String) -> Bool{//search Pizza for 2 ingredients
        if let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient), let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchPizza(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Pizza for 3 ingredients
        if let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient), let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient1), let _ = chickenPizza.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }
    
//////////search Chicken Tortilla Bites recipe for 1, 2, or 3 ingredients
    func searchBites(ingredient: String) -> Bool{//search Bites for 1 ingredient
        if let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchBites(ingredient: String, ingredient1: String) -> Bool{//search Bites for 2 ingredients
        if let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient), let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchBites(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Bites for 3 ingredients
        if let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient), let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient1), let _ = chickenTortillaBites.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }
    
//////////search Burrito recipe for 1, 2, or 3 ingredients
    func searchBurrito(ingredient: String) -> Bool{//search Burrito for 1 ingredient
        if let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient){
            return true
        } else {
            return false
        }
    }
    func searchBurrito(ingredient: String, ingredient1: String) -> Bool{//search Burrito for 2 ingredients
        if let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient), let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient1){
            return true
        } else {
            return false
        }
    }
    func searchBurrito(ingredient: String, ingredient1: String, ingredient2 : String) -> Bool{//search Burrito for 3 ingredients
        if let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient), let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient1), let _ = breakfastBurrito.arrayOfIngredients?.index(of: ingredient2){
            return true
        } else {
            return false
        }
    }

    override func viewDidLoad() {
        
        recipe1Label.text = ""
        recipe2Label.text = ""
        recipe3Label.text = ""
        recipe4Label.text = ""
        recipe5Label.text = ""
        
        chipsAndQueso.recipeName = "Chips and Queso"
        fondue.recipeName = "Fondue"
        chickenQuesadilla.recipeName = "Chicken Quesadilla"
        chickenPizza.recipeName = "Chicken Pizza"
        breakfastBurrito.recipeName = "Breakfast Burrito"
        chickenTortillaBites.recipeName = "Chicken Tortilla Bites"
        
        chipsAndQueso.recipe = "Either use tortilla chips, or toast Tortillas into chips. Set tortilla chips aside. Turn stove to medium-high and add 2 cups of Cheddar Cheese to warm saucepan. Add heat slowly, until all cheese is melted. When cheese fully melts, remove saucepan from heat and serve with tortilla chips. Feeds 3-5 people."
        fondue.recipe = "Turn stove to medium-high and add 3 cups of Cheddar Cheese to warm saucepan. Add heat slowly, until all cheese is melted. When cheese fully melts, remove saucepan from heat and serve with dippable items such as bread, crackers, etc. Feeds 2-4 people."
        chickenQuesadilla.recipe = "Turn stove to medium-low, and warm one tortilla up on a skillet. When warm, top tortilla with: 1 cup shredded Cheddar Cheese and 1 Chicken Breast, shredded. Add contents to half of the tortilla, making it easier to fold in half when complete. Fold tortilla in half, and return to skillet. Toast till tortilla is golden-brown, and contents are properly melted. Serve with Sour Cream or Guacamole. One quesadilla feeds 1-2 people."
        chickenPizza.recipe = "Preheat oven to 400 degrees fahrenheit. Using a tortilla or two as the base, top tortilla(s) with: 1/2 cup Marinara Sauce, 1 cup shredded Cheddar Cheese, one Chicken Breast, shredded. Add more Cheddar Cheese to taste. Bake pizza in oven for 20-25 minutes, or until cheese has turned golden-brown. Remove, let cool, and serve. Feeds 2-4 people."
        breakfastBurrito.recipe = "Turn stove to medium-low, and warm one tortilla up on a skillet. When warm, top tortilla with: 2 Eggs, scrambled, 1 Chicken Breast, shredded, and 1/4 cup of Salsa. Top with 1/4 cup Cheddar Cheese, shredded. Wrap contents in Tortilla, Burrito style, and serve. Feeds 1 person."
        chickenTortillaBites.recipe = "Turn stove to medium-low, and warm one tortilla up on a skillet. When warm, spread tortilla with thin layer of butter. Top with 1 Chicken Breast, shredded. Drizzle Ranch to taste. Roll tortilla and contents, then cut roll into thirds, and serve. Feeds 1-2 people."
        
        chipsAndQueso.arrayOfIngredients = ["Tortillas", "Cheddar Cheese"]
        fondue.arrayOfIngredients = ["Cheddar Cheese"]
        chickenQuesadilla.arrayOfIngredients = ["Cheddar Cheese", "Chicken Breast", "Tortillas"]
        chickenPizza.arrayOfIngredients = ["Cheddar Cheese", "Chicken Breast", "Tortillas", "Marinara Sauce"]
        breakfastBurrito.arrayOfIngredients = ["Tortillas", "Cheddar Cheese", "Chicken Breast", "Eggs", "Salsa"]
        chickenTortillaBites.arrayOfIngredients = ["Tortillas", "Chicken Breast", "Ranch", "Butter"]
        
        let myPicker = UIPickerView()
        let myPicker2 = UIPickerView()
        let myPicker3 = UIPickerView()
        myPicker.delegate = self
        myPicker2.delegate = self
        myPicker3.delegate = self
        ingredient1Field.inputView = myPicker
        ingredient2Field.inputView = myPicker2
        ingredient3Field.inputView = myPicker3
        myPicker.tag = 0
        myPicker2.tag = 1
        myPicker3.tag = 2
        
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

