//
//  ViewController.swift
//  CtoFConverterPro
//
//  Created by Ari Klebanov on 10/1/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var celsiusField: UITextField!
    @IBOutlet weak var fahrenheitField: UITextField!
    @IBOutlet weak var cTillFreeze: UILabel!
    @IBOutlet weak var fTillFreeze: UILabel!
    @IBOutlet weak var cTillBoil: UILabel!
    @IBOutlet weak var fTillBoil: UILabel!
    @IBOutlet weak var kelvin: UILabel!
    @IBOutlet weak var factLabel: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true;
    }

    func updateTemp (tag : Int) {
        var tempK : Int
        var tempF : Int
        var tempC : Int
        var cTillF : Int
        var fTillF : Int
        var cTillBol : Int
        var fTillBol : Int
        if tag == 0 {
            //fahrenheitField.text! = ""
            tempC = Int(celsiusField.text!)!
            tempF = (tempC * 2) + 32
            tempK = tempC + 270
            cTillF = tempC
            cTillBol = 100 - tempC
            fTillF = tempF - 32
            fTillBol = 212 - tempF
            factLabel.text! = "Fun Facts!"
            cTillFreeze.text! = "\(cTillF) °C until freezing"
            fTillFreeze.text! = "\(fTillF) °F until freezing"
            cTillBoil.text! = "\(cTillBol) °C until boiling"
            fTillBoil.text! = "\(fTillBol) °F until boiling"
            fahrenheitField.text! = String(Int(tempF))
            kelvin.text! = "This is also \(tempK) degrees in Kelvin"
            
        } else {
            //celsiusField.text! = ""
            tempF = Int(fahrenheitField.text!)!
            tempC = (tempF - 32) / 2
            tempK = tempC + 270
            cTillF = tempC
            cTillBol = 100 - tempC
            fTillF = tempF - 32
            fTillBol = 212 - tempF
            factLabel.text! = "Fun Facts!"
            cTillFreeze.text! = "\(cTillF) °C until freezing"
            fTillFreeze.text! = "\(fTillF) °F until freezing"
            cTillBoil.text! = "\(cTillBol) °C until boiling"
            fTillBoil.text! = "\(fTillBol) °F until boiling"
            celsiusField.text! = String(Int(tempC))
            kelvin.text! = "This is also \(tempK) degrees in Kelvin"
        }
//        var tempK : Int
//        var tempF : Int
//        var tempC : Int
//        var cTillF : Int
//        var fTillF : Int
//        var cTillBol : Int
//        var fTillBol : Int
//        if fahrenheitField.text!.isEmpty {
//            tempC = Int(celsiusField.text!)!
//            tempF = (tempC * (9/5)) + 32
//            tempK = tempC + 270
//            cTillF = tempC
//            cTillBol = 100 - tempC
//            fTillF = tempF - 32
//            fTillBol = 212 - tempF
//            factLabel.text! = "Fun Facts!"
//            cTillFreeze.text! = "\(cTillF) °C until freezing"
//            fTillFreeze.text! = "\(fTillF) °F until freezing"
//            cTillBoil.text! = "\(cTillBol) °C until boiling"
//            fTillBoil.text! = "\(fTillBol) °F until boiling"
//            fahrenheitField.text! = String(Int(tempF))
//            kelvin.text! = "This is also \(tempK) degrees in Kelvin"
//
//        } else if celsiusField.text!.isEmpty {
//            tempF = Int(fahrenheitField.text!)!
//            tempC = (tempF - 32) * (5/9)
//            tempK = tempC + 270
//            cTillF = tempC
//            cTillBol = 100 - tempC
//            fTillF = tempF - 32
//            fTillBol = 212 - tempF
//            factLabel.text! = "Fun Facts!"
//            cTillFreeze.text! = "\(tempF) °C until freezing"
//            fTillFreeze.text! = "\(fTillF) °F until freezing"
//            cTillBoil.text! = "\(cTillBol) °C until boiling"
//            fTillBoil.text! = "\(fTillBol) °F until boiling"
//            celsiusField.text! = String(Int(tempC))
//            kelvin.text! = "This is also \(tempK) degrees in Kelvin"
//        }
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTemp (tag: textField.tag)
        
    }
    
    override func viewDidLoad() {
        self.celsiusField.delegate = self
        self.fahrenheitField.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

