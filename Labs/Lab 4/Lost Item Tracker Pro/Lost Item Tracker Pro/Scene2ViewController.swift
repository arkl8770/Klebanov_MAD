//
//  Scene2ViewController.swift
//  Lost Item Tracker Pro
//
//  Created by Ari Klebanov on 10/10/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {
    

    
    @IBAction func onTapGestureRecognized(_ sender: UITapGestureRecognizer) {
        userName.resignFirstResponder()
        userLocation.resignFirstResponder()
    }
    
    
    @IBOutlet weak var userName: UITextField!

    @IBOutlet weak var userLocation: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneItem" {
            let ViewController = segue.destination as! ViewController
            if userName.text!.isEmpty == false {
                ViewController.input.itemName = userName.text
                
            }
            if userName.text!.isEmpty == false {
                ViewController.input.itemLocation = userLocation.text
            }
        }
        
    }
    

    override func viewDidLoad() {
        userName.delegate = self
        userLocation.delegate = self

        
        
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {

        textField.resignFirstResponder()
        return true
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
