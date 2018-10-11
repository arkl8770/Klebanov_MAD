//
//  ViewController.swift
//  Lost Item Tracker Pro
//
//  Created by Ari Klebanov on 10/10/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import UIKit

class ViewController: UIViewController {



   
    @IBOutlet weak var locationLabel: UILabel!
    @IBOutlet weak var itemLabel: UILabel!
    
    var input = Item()
    
    let fileName = "data.plist"
 
    @IBAction func unwindSegue(_ segue:UIStoryboardSegue) {
        
        
            itemLabel.text = input.itemName
            locationLabel.text = input.itemLocation
        
    }
    
    func dataFileURL(_fileName : String) -> URL? {
        let urls = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        var url : URL?
        url = urls.first?.appendingPathComponent(fileName)
        return url
    }
    

    
    
    override func viewDidLoad() {
        
        itemLabel.text = ""
        locationLabel.text = ""
        
        
        let fileURL = dataFileURL(_fileName: fileName)
        if FileManager.default.fileExists(atPath: (fileURL?.path)!){
            let URL = fileURL!
            do {
                let data = try Data(contentsOf: URL)
                let decoder = PropertyListDecoder()
                input = try decoder.decode(Item.self, from: data)
                itemLabel.text = input.itemName
                locationLabel.text = input.itemLocation
            } catch {
                print ("No File")
            }
        } else {
            print ("File does not exist")
        }
        let applicationInstance = UIApplication.shared
        NotificationCenter.default.addObserver(self, selector: #selector(self.applicationWillResignActive(_:)), name: Notification.Name.UIApplicationWillResignActive, object: applicationInstance)
        // Do any additional setup after loading the view, typically from a nib.
        super.viewDidLoad()
    }
    
    @objc func applicationWillResignActive(_ notification: Notification){
        let fileURL = dataFileURL(_fileName: fileName)
        let encoder = PropertyListEncoder()
        encoder.outputFormat = .xml
        do {
            let plistData = try encoder.encode(input)
            try plistData.write(to: fileURL!)
        } catch {
            print ("Write failed")
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

