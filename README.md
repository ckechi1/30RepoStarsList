# 30RepoStarsList  

this is a Small android App that consume the github Api using volley to get the list of the most starred repositories in the last 30 days 
  
## Getting Started 

the goal is to get the list of repositories at this link : 
``` 
https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc 

```
then parse the Json data and display the result in a recyclerview and a cardview to make it looking more attractive. 
We will fetch the information like the name of the repository , the number of star for the repository  , the username and avatar of the owner  from the JSON Url .  

### Mockup     

![alt text]( https://github.com/ckechi1/30RepoStarsList/blob/master/mockup.png)

###  Built With  

* Volley : a library that makes networking for Android apps build by Google , Volley will reduce the number of Coding lines to make GET or POST calls to the web service. Easy to implement and ideal for small application 

* RecyclerView : We will use this library to display a large amount of data in a list, It provides a feature to implement the list in form of horizontal, vertical and Expandable.
 
* CardView : This component helps us to create  a good looking user interface , we use it in this app to design RecyclerView item. 

* Picasso : this library will download and manage our app with less code and its easy to setup 
 
 ### Installing  
 install git and android Studio  and then 
``` 
 VCS > Checkout from version control > Git   
 ``` 
clone using this link  
``` 
 https://github.com/ckechi1/30RepoStarsList.git 
 
``` 
 or download and extract the project in your android studio project folder , build and Run until gradle install all the components 
 
  
  
   
   
     
     
      
