//
//  ViewController.swift
//  Font Master Pro
//
//  Created by Ari Klebanov on 9/19/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var previewLabel: UILabel!
    @IBOutlet weak var fontColorControl: UISegmentedControl!
    @IBOutlet weak var fontColorPreview: UIImageView!
    @IBOutlet weak var capsSwitch: UISwitch!
    @IBOutlet weak var capsLabel: UILabel!
    @IBOutlet weak var fontSize: UILabel!
    
    var fontCGFloat : CGFloat = 40.0
    
    
    
    
    @IBAction func fontSizeSlider(_ sender: UISlider) {
        let font = sender.value // float
        fontSize.text = String (format: "%.0f", font) // converts float to string
        fontCGFloat = CGFloat(font) // converts float to CGFloat
        
    }
    
    
    @IBAction func refreshButton(_ sender: UIButton) { //updates previewText
        updateCaps()
        updatePreviewColor()
        updateFontSize()
    }
    @IBAction func fontColorControl(_ sender: UISegmentedControl) {
        updateColor()
    }
    
    func updateFontSize(){
        previewLabel.font = UIFont.systemFont(ofSize: fontCGFloat)
    }
    
    func updatePreviewColor(){
        if fontColorControl.selectedSegmentIndex == 0 {
            previewLabel.textColor = UIColor.black
        }else if fontColorControl.selectedSegmentIndex == 1{
            previewLabel.textColor = UIColor.red
        }else if fontColorControl.selectedSegmentIndex == 2{
            previewLabel.textColor = UIColor.blue
        }else if fontColorControl.selectedSegmentIndex == 3{
            previewLabel.textColor = UIColor.green
        }
    }
    func updateColor(){
        if fontColorControl.selectedSegmentIndex == 0 {
            fontColorPreview.image = UIImage(named: "colorBlack")
        }else if fontColorControl.selectedSegmentIndex == 1{
            fontColorPreview.image = UIImage(named: "colorRed")
        }else if fontColorControl.selectedSegmentIndex == 2{
            fontColorPreview.image = UIImage(named: "colorBlue")
        }else if fontColorControl.selectedSegmentIndex == 3{
            fontColorPreview.image = UIImage(named: "colorGreen")
        }
    }
    
    func updateCaps(){
        if capsSwitch.isOn {
            previewLabel.text = previewLabel.text?.uppercased()
        } else {
            previewLabel.text = previewLabel.text?.lowercased()
        }
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

