// CONFIGURATION
config create_schema: false, load_new: true, load_vertex_threads: 3

// DATA INPUT

inputfileV = '/data/vertices/'
inputfileE = '/data/edges/'
//vertex files
pokemonFile = File.csv(inputfileV + "pokemon.csv").delimiter(',')
abilitiesFile = File.csv(inputfileV + "abilities.csv").delimiter(',')
egggroupsFile = File.csv(inputfileV + "egg_groups.csv").delimiter(',')
itemcategoriesFile = File.csv(inputfileV + "item_categories.csv").delimiter(',')
itempocketsFile = File.csv(inputfileV + "item_pockets.csv").delimiter(',')
itemsFile = File.csv(inputfileV + "items.csv").delimiter(',')
locationsFile = File.csv(inputfileV + "locations.csv").delimiter(',')
movesFile = File.csv(inputfileV + "moves.csv").delimiter(',')
regionsFile = File.csv(inputfileV + "regions.csv").delimiter(',')
statsFile = File.csv(inputfileV + "stats.csv").delimiter(',')
typesFile = File.csv(inputfileV + "types.csv").delimiter(',')

//edge files
categorypocketEdgeFile = File.csv(inputfileE + "category_has_pocket_type.csv").delimiter(',')
itemcategoryEdgeFile = File.csv(inputfileE + "item_has_category.csv").delimiter(',')
locationregionEdgeFile = File.csv(inputfileE + "location_belongs_to_region.csv").delimiter(',')
pokemonitemEdgeFile = File.csv(inputfileE + "pokemon_can_use_item.csv").delimiter(',')
pokemonabilitiesEdgeFile = File.csv(inputfileE + "pokemon_has_abilities.csv").delimiter(',')
pokemoneggEdgeFile = File.csv(inputfileE + "pokemon_has_egg_groups.csv").delimiter(',')
pokemonevolutionEdgeFile = File.csv(inputfileE + "pokemon_evolves_to.csv").delimiter(',')
pokemonlocationEdgeFile = File.csv(inputfileE + "pokemon_has_location_index.csv").delimiter(',')
pokemonmovesEdgeFile = File.csv(inputfileE + "pokemon_has_moves.csv").delimiter(',')
pokemonstatsEdgeFile = File.csv(inputfileE + "pokemon_has_stats.csv").delimiter(',')
pokemontypeEdgeFile = File.csv(inputfileE + "pokemon_has_type.csv").delimiter(',')

//load vertices

load(pokemonFile).asVertices {
    label "pokemon"
    key "pokemon_id"
}

load(abilitiesFile).asVertices {
    label "abilities"
    key "ability_id"
}

load(egggroupsFile).asVertices {
    label "egg"
    key "egg_groups_id"
}

load(itemcategoriesFile).asVertices {
    label "item_category"
    key "category_id"
}

load(itempocketsFile).asVertices {
    label "item_pockets"
    key "pocket_id"
}

load(itemsFile).asVertices {
    label "items"
    key "item_id"
}

load(locationsFile).asVertices {
    label "location"
    key "location_id"
}

load(movesFile).asVertices {
    label "moves"
    key "move_id"
}

load(regionsFile).asVertices {
    label "region"
    key "region_id"
}

load(statsFile).asVertices {
    label "stat"
    key "stat_id"
}

load(typesFile).asVertices {
    label "type"
    key "type_id"
}

//load edges

load(categorypocketEdgeFile).asEdges {
    label "has_pocket_type"
    outV "category_id", {
        label "item_category"
        key "category_id"
    }
    inV "pocket_id", {
        label "item_pockets"
        key "pocket_id"
    }
}

load(itemcategoryEdgeFile).asEdges {
    label "has_category"
    outV "item_id", {
        label "items"
        key "item_id"
    }
    inV "category_id", {
        label "item_category"
        key "category_id"
    }
}

load(locationregionEdgeFile).asEdges {
    label "is_in_region"
    outV "location_id", {
        label "location"
        key "location_id"
    }
    inV "region_id", {
        label "region"
        key "region_id"
    }
}

load(pokemonitemEdgeFile).asEdges {
    label "uses_item"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "item_id", {
        label "items"
        key "item_id"
    }
}

load(pokemonabilitiesEdgeFile).asEdges {
    label "has_ability"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "ability_id", {
        label "abilities"
        key "ability_id"
    }
}

load(pokemoneggEdgeFile).asEdges {
    label "hatches_from"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "egg_groups_id", {
        label "egg"
        key "egg_groups_id"
    }
}

load(pokemonevolutionEdgeFile).asEdges {
    label "evolves_to"
    outV "from_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "to_id", {
        label "pokemon"
        key "pokemon_id"
    }
}

load(pokemonlocationEdgeFile).asEdges {
    label "has_location"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "game_index", {
        label "location"
        key "game_index"
    }
}

load(pokemonmovesEdgeFile).asEdges {
    label "has_move"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "move_id", {
        label "moves"
        key "move_id"
    }
}

load(pokemonstatsEdgeFile).asEdges {
    label "has_stat"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "stat_id", {
        label "stat"
        key "stat_id"
    }
}

load(pokemontypeEdgeFile).asEdges {
    label "has_type"
    outV "pokemon_id", {
        label "pokemon"
        key "pokemon_id"
    }
    inV "type_id", {
        label "type"
        key "type_id"
    }
}
