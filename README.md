# NeuroDatabasesSearchApp [In Progress]
A simple Java application that combines multiple neuroscience databases into one search result!

### Included Databases:
[NeuroML-DB](https://neuroml-db.org/): a database of computational models of neurons and networks that makes it easier to evaluate and reuse these models.  
[ModelDB](https://modeldb.science/): a curated database of published models in the broad domain of computational neuroscience.

[NIMH Data Archive](https://nda.nih.gov/nda/apis.html)

[OpenNeuro](https://openneuro.org/)

[EBRAINS](https://www.ebrains.eu/)

### Features:
1. Advance Search:
    - You can use AND / OR to make precise searches
    - You can filter the search results by date range, data size, etc.
2. Display Views:
    - You can sort search results from all databases in an integrated fashion;
    - Or, you can display the results from each database independently
3. Download Data:
    - You can download data like models, experiment datasets, and neuron reconstructions from the search results
4. Save Search Results:
    - You can save search results locally (while not downloading the associated files)
    - When you open the application again, the saved search results will be reloaded
  
### Database API Documentations 
NeuroML-DB: https://neuroml-db.org/api
ModelDB: https://modeldb.science/api

### Example Call to API using OkHttp in Java:
See [src/app/Main.java](https://github.com/MarksonChen/NeuroDatabasesSearchApp/blob/master/src/app/Main.java)
<img width="1512" alt="image" src="https://github.com/MarksonChen/NeuroDatabasesSearchApp/assets/46666959/49a03ec2-0b29-4c1c-8719-bfd93ee26215">

### Example Call to API using [hoppscotch.io](https://hoppscotch.io/):
<img width="1031" alt="image" src="https://github.com/MarksonChen/NeuroDatabasesSearchApp/assets/46666959/83f72b5a-f9fd-4488-9ee4-04229e3a5430">
