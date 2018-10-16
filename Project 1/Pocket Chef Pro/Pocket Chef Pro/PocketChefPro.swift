//
//  PocketChefPro.swift
//  Pocket Chef Pro
//
//  Created by Ari Klebanov on 10/11/18.
//  Copyright © 2018 Ari Klebanov. All rights reserved.
//

import Foundation

class Recipe : Codable {
    var recipeName : String?
    var recipe : String?
    var arrayOfIngredients: [String?]?
    var imgURL : String?
}
