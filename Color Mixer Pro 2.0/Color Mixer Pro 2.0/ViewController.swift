//
//  ViewController.swift
//  Color Mixer Pro 2.0
//
//  Created by Ari Klebanov on 9/12/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    
    var colorSelected: Int = 0
        //for colorSelected, 0 = none, 1 = red, 2 = blue, 3 = yellow
    var newColor: Int = 0
    var sumColors: Int = 0
    var timesCalled: Int = 0
    
    func checkColor(newColor: Int) -> Int {
        timesCalled = timesCalled + 1
        if sumColors != newColor{
            sumColors = sumColors + newColor
            return sumColors
        }else{
            return sumColors
        }
    }
    
    func combineColors (sumColors: Int) {
        if sumColors == 3{
            //color is Purple
            comboView.image = #imageLiteral(resourceName: "colorPurple")
        }else if sumColors == 4{
            //color is Orange
            comboView.image = #imageLiteral(resourceName: "colorOrange")
        }else if sumColors == 5{
            //color is Green
            comboView.image = #imageLiteral(resourceName: "colorGreen")
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @IBOutlet weak var restartButton: UIButton!
    @IBOutlet weak var buttonRed: UIButton!
    @IBOutlet weak var buttonYellow: UIButton!
    @IBOutlet weak var buttonBlue: UIButton!
    @IBOutlet weak var comboView: UIImageView!
    @IBOutlet weak var comboLabel: UILabel!
    @IBOutlet weak var textView: UITextView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var imageView2: UIImageView!
    @IBOutlet weak var imageView3: UIImageView!
    
    
    
    @IBAction func pushButton(_ sender: UIButton) {
        //this function occurs when the user chooses Red
        imageView.image = #imageLiteral(resourceName: "colorWhite")
        newColor = 1
        sumColors = checkColor(newColor: newColor)
        sender.isHidden = true
        if timesCalled == 1{
            textView.text = "Please choose a second color. "
        }else if timesCalled == 2{
            comboLabel.text = "Your combination!"
            textView.text = "Yay! This worked! Wanna restart?"
            
            combineColors(sumColors: sumColors)
            if (imageView2.image == #imageLiteral(resourceName: "colorWhite")){
                imageView3.image = #imageLiteral(resourceName: "colorWhite")
                buttonYellow.isHidden = true
            }else{
                imageView2.image = #imageLiteral(resourceName: "colorWhite")
                buttonBlue.isHidden = true
            }
        }
        
        
        

        
    }
    @IBAction func pushButton2(_ sender: UIButton) {
        //this function occurs when the user chooses Blue
        imageView2.image = #imageLiteral(resourceName: "colorWhite")
        newColor = 2
        sumColors = checkColor(newColor: newColor)
        sender.isHidden = true
        if timesCalled == 1{
            textView.text = "Please choose a second color."
        }else if timesCalled == 2{
            comboLabel.text = "Your combination!"
            textView.text = "Yay! This worked! Wanna restart?"
            combineColors(sumColors: sumColors)
            if (imageView.image == #imageLiteral(resourceName: "colorWhite")){
                imageView3.image = #imageLiteral(resourceName: "colorWhite")
                buttonYellow.isHidden = true
            }else{
                imageView.image = #imageLiteral(resourceName: "colorWhite")
                buttonRed.isHidden = true
            }
            
        }
        

        
        
        
    }
    
    
    @IBAction func pushButton3(_ sender: UIButton) {
        //this function occurs when the user chooses Yellow
        imageView3.image = #imageLiteral(resourceName: "colorWhite")
        newColor = 3
        sumColors = checkColor(newColor: newColor)
        sender.isHidden = true
        if timesCalled == 1{
            textView.text = "Please choose a second color."
        }else if timesCalled == 2{
            comboLabel.text = "Your combination!"
            textView.text = "Yay! This worked! Wanna restart?"

            combineColors(sumColors: sumColors)
            if (imageView2.image == #imageLiteral(resourceName: "colorWhite")){
                imageView.image = #imageLiteral(resourceName: "colorWhite")
                buttonRed.isHidden = true
            }else{
                imageView2.image = #imageLiteral(resourceName: "colorWhite")
                buttonBlue.isHidden = true
            }
        }
    }
    
    
    
    
    
    
    
    
    
    @IBAction func resetStoryboard(_ sender: UIButton) {
        buttonRed.isHidden = false
        buttonBlue.isHidden = false
        buttonYellow.isHidden = false
        comboView.image = #imageLiteral(resourceName: "colorGray")
        comboLabel.text = ""
        textView.text = "Choose a color!"
        imageView.image = #imageLiteral(resourceName: "colorRed")
        imageView2.image = #imageLiteral(resourceName: "colorBlue")
        imageView3.image = #imageLiteral(resourceName: "colorYellow")
        colorSelected = 0
        newColor = 0
        sumColors = 0
        timesCalled = 0
    }
    
    
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

