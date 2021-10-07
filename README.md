# Hello, All! <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

## QAFinalProject - Medicine
Final project using Java,  Maven, Spring Boot, MySQL and H2. The main subject is Medicine. Medicine is a package and API that allows you to use the basic CRUD function for Medicine Objects.

Medicine contains upto 9 fields:
- ID - ```id```.
- Common Name - ```commonName```.
- IUPAC Name - ```iupacName```.
- Chemical Formula - ```chemicalFormula```.
- Molecular Weight - ```molecularWeight```.
- Whether it is Approved by MHRA - ```isApprovedByMHRA```.
- Whether it is a Controlled Drug - ```isControlledDrug```.
- Recommended Minimum Storage Temp - ```minStoreTemp```.
- Recommended Maximum Storage - ```maxStoreTemp```.

For more details on these field please check out the Javadoc on [Medicine.java](https://github.com/MrRBM97/QAFinalProject/blob/main/src/main/java/com/mrrbm/medicine_qaproject/medicine/domain/Medicine.java).

This project used MySQL when prod properties are run, and during testing uses H2 due to H2 being significantly quicker.

---
## Why Did We Do This Project?

The main purpose of this project was to utilise and demonstrate the skill we have learnt during the DfE backed Software Development Bootcamp, run by QA. The core skills being tested in the project are:
- Java.
- Spring Boot & Maven.
- Working with Databases (H2 and MySQL), CRUD.
- Continuous Integration.
 - Git & Github (especially using the feature-branch model).
- Repository and Documentation Management.
 - Jira.
 - Agile processes (User Stories, MoSCoW, Story Points & Acceptance Criteria).
 - Risk Assessment
---
## How I Excepted The Project To Go?

Going into the project I was confident in creating the functionality (Entity, Repo, Service and Controller), this was because I already had a good understand of how to create these files. As a result of feeling confident I gave myself the challenge to have more fields, instead of the 2 or 3 like we had practiced as part of the training. By doing this I decided to implement the Builder Pattern, as this would allow me users more flexibility when it comes to creating and updating Medicine Objects. I also calculated that if I used the standard constructor methods I would need a total of 362,880 constructors to cover all potential field combination, therefore using the Builder Pattern would also make the code more manageable for me and more readable to anyone who wished to look at my program and use it.

I felt less confident about testing, especially using Mockito. This is something that I have been putting a lot of time into, but was struggling to full grasp why we use it. I could implement it and write the code to make it work, but I didn't have a full understanding of the tool. I will explain in the next section how I got on using it.

---
## What Went Well and What Didn't Go To Plan?
### What Went Well
I managed to implement the functionality of the program and API without any flaws. I was able to complete all this code in a matter of hours, this was what I planned so that I would have as much time on testing as possible.

I was also able to move into the stretch goals by using Lombok to increase readability and accessibility.

In my planning stage I made the decision to ensure that each field in my Entity had adequate Javadoc's documentation, as some of the fields were very specialised and I wanted anyone to be able to full utilise my program and have minimal roadblocks to access. I was able to complete this within the time frame mentioned above.

### What Didn't Go To Plan
As expected testing was a big topic when it came to my own knowledge and understanding. This meant that the timescale that I set had to be extended, this was greatly exacerbated by having a couple of day were I was not feeling well. After some trial and error, additional tutorial and self-lead research I now have a far better understanding of Mockito, and I believe that I would now be able to implement this style of testing more easily. This was evident as I manage to complete 3 of the tests quicker than expected.

Do to the ill-health mentioned above my overall timescale was extended, and I could not move onto the stretch goals as planned. This did not prevent me from completing the core MVP on time.

I also made some spelling mistakes when creating packages/directories, this lead to difficulties when trying to change them. I now know, and have saved the command ```git rm -rf --cache [file/dir]```.

---
## Possible Improvements For Future Revisions Of The project
I would like to extend the fields to include recommended dosages, wholesale prices and retail prices. After this I would want to create 3 DTO's that would like to 3 new Entities (Patient, Doctor and Pharmacy). This would allow for those that need to know different fields would have access to those fields and add an added layer of protection against some of the more sensitive information.

I would also like to add custom exception and increase the negative unit testing - I managed to include a few negative testing but I believe by adding more I would be able to give developers greater ease when using my API.

---
## Postman Screenshots
##### Post
![Image showing Postman Post](/images/Postman-post.JPG)

##### Get After Post
![Image showing Postman Get After Post](/images/Postman-get-afterPost.JPG)

##### Put
![Image showing Postman Put](/images/Postman-get-afterPost.JPG)

##### Get After Put
![Image showing Postman Get After Post](/images/Postman-get-afterPut.JPG)

##### Delete
![Image showing Postman Delete](/images/Postman-delete.JPG)

##### Get After Delete
![Image showing Postman Get After Post](/images/Postman-get-afterDelete.JPG)
