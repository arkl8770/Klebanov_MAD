//
//  ViewController.swift
//  Midterm Workout App
//
//  Created by Ari Klebanov on 10/18/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    

    @IBOutlet weak var runSwimBikeSegmentedControl: UISegmentedControl!
    @IBOutlet weak var workoutTimeField: UITextField!
    @IBOutlet weak var milesLabel: UILabel!
    @IBOutlet weak var caloriesLabel: UILabel!
    @IBOutlet weak var weeklySwitch: UISwitch!
    @IBOutlet weak var perWeekSlider: UISlider!
    @IBOutlet weak var imageView: UIImageView!
    
    @IBAction func perWeekSlider(_ sender: UISlider) {
    }
    @IBAction func runSwimBikeSegmentedControl(_ sender: UISegmentedControl) {
    }
    @IBAction func workoutButton(_ sender: UIButton) {
        if workoutTimeField.text?.isEmpty == false {
            if Int(workoutTimeField.text!)! < 30{
                let alert = UIAlertController(title: "Warning!", message: "Your workout was less than 30 minutes. You should really work out for at least 30 minutes a day, for optimal results", preferredStyle: UIAlertControllerStyle.alert)
                let okAction = UIAlertAction(title: "30 minutes it is!", style: UIAlertActionStyle.default, handler: {action in
                    self.workoutTimeField.text="30"
                    self.updateView()})
                let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertActionStyle.cancel, handler: nil)
                alert.addAction(okAction)
                alert.addAction(cancelAction)
                present(alert, animated: true, completion: nil)
            } else {
                updateView()
            }
        }
    }
    @IBAction func onTapRecognizer(_ sender: UITapGestureRecognizer) {
        workoutTimeField.resignFirstResponder()
    }
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func updateView(){
        var frequency : Float
        if runSwimBikeSegmentedControl.selectedSegmentIndex == 0{
            imageView.image = #imageLiteral(resourceName: "run")
            let milesPerHour = 6.00
            let caloriesPerHour = 600
            var milesRan = milesPerHour * (Double(workoutTimeField.text!))!/60
            var caloriesBurned = caloriesPerHour * Int(workoutTimeField.text!)!/60
            if weeklySwitch.isOn {
                frequency = perWeekSlider.value
                milesRan = milesRan*Double(frequency)
                caloriesBurned = caloriesBurned*Int(frequency)
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            } else {
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            }
        } else if runSwimBikeSegmentedControl.selectedSegmentIndex == 1{
            imageView.image = #imageLiteral(resourceName: "swim")
            let milesPerHour = 2.00
            let caloriesPerHour = 420
            var milesRan = milesPerHour * (Double(workoutTimeField.text!))!/60
            var caloriesBurned = caloriesPerHour * Int(workoutTimeField.text!)!/60
            if weeklySwitch.isOn {
                frequency = perWeekSlider.value
                milesRan = milesRan*Double(frequency)
                caloriesBurned = caloriesBurned*Int(frequency)
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            } else {
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            }
        } else if runSwimBikeSegmentedControl.selectedSegmentIndex == 2{
            imageView.image = #imageLiteral(resourceName: "bike")
            let milesPerHour = 15.00
            let caloriesPerHour = 510
            var milesRan = milesPerHour * (Double(workoutTimeField.text!))!/60
            var caloriesBurned = caloriesPerHour * Int(workoutTimeField.text!)!/60
            if weeklySwitch.isOn {
                frequency = perWeekSlider.value
                milesRan = milesRan*Double(frequency)
                caloriesBurned = caloriesBurned*Int(frequency)
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            } else {
                milesLabel.text = "\(milesRan) miles"
                caloriesLabel.text = "\(caloriesBurned) calories burned"
            }
        }
        
        
    }
    

    override func viewDidLoad() {
        workoutTimeField.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

