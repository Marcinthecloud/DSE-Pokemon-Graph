# Gotta Graph 'em All!
![Alt text](https://www.datastax.com/wp-content/uploads/2016/08/dsegraph.jpg)

This demo is intended to help get you started with DSE Graph. It includes schemas, data, and mapper script for the DataStax Graph Loader.

LICENSE: [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

###About the Data
The data comes to us from the [pokeapi](https://github.com/PokeAPI/pokeapi). I took the liberty of cleaning the data files and choosing the ones that had relationships applicable to a graph database. I've also changed the file and header names to help new comers better understand what's happening inside DSE Graph.

###Issues
* Some data needs to be cleaned further for null property values  


###Prerequisites
* [Learn some Graph](https://academy.datastax.com/courses/ds330-datastax-enterprise-graph) <- this will give you ideas on how to query this graph
* [DataStax Graph Loader](https://academy.datastax.com/downloads/download-drivers)
* [DataStax Enterprise 5.0 or greater](https://www.datastax.com/downloads)
* [DataStax Studio 1.0 or greater](https://www.datastax.com/downloads)


###How-to:
1. Start DataStax Enterprise in graph mode mode
2. Start DataStax Studio - on your local machine it'll bind to http://localhost:9091
3. Edit ```poke_mapper.groovy``` so that the paths for *inputfileV* and *inputfileE* files = `'/path/to/this/directory/data/'`

##Let's get started

#####In DataStax Studio create a new connection with a new graph called 'poke_graph' (or what ever you want the graph to be called)
![Alt text](http://i.imgur.com/zNrR722.png)

#####Next, paste the schema from the `schema.groovy` file into a new gremlin box:
![Alt text](http://i.imgur.com/XB7PGkU.png)

If you'd like to add more indices for different types of traversals, you can always add them after the fact. The ones in the schema file are for the Graph Loader to do look ups and match vertices to edges.

#####Click the `real-time` play button to execute. When it finishes, hit the `schema` button at the top right of Studo.
![Alt text](http://i.imgur.com/M8cSueW.png)

Note, there's plenty of other connections we can make with this dataset. Feel free to explore and play around!


###Now we're going to load the data

`sudo ./graphloader /path/to/poke_mapper.groovy -graph poke_graph -address localhost -abort_on_prep_errors false
`

Some of the properties within the CSV files contain empty fields which is OK for this demo but will cause errors. This is why we set the `-abort_on_prep_errors` flag



###Play time! Remember that Studio truncates results to 1000 by default.

![Alt text](http://i.imgur.com/ptyBTBb.png)
![Alt text](http://i.imgur.com/fOFgwKe.png)
