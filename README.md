<img src=/images/QA-Final-Project.jpg>

# Hello, All! <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

## QAFinalProject - Medicine <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f48a.png?v8 width="30px">
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

I came up with the idea of basing my project on medicine because of experiences I have had. I take several tablets everyday, but when you google about the tablet and medicine you get lots of information, some of which is contradictory. Therefore my idea was to have a single central database for every and all medication. Obviously this is only a very small part of what is needed, but I wanted to base my final QA Bootcamp project on something that means something to me, rather than create something that has the same functionality but with a random topic.

## Table of Content
  * [Why Did We Do This Project? <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f447.png?v8 width="30px">](#why-did-we-do-this-project)
  * [How I Expected The Project To Go? <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4aa.png?v8 width="30px">](#how-i-expected-the-project-to-go)
  * [What Went Well and What Didn't Go To Plan?](#what-went-well-and-what-didn-t-go-to-plan)
    + [What Went Well <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8 width="30px">](#what-went-well)
    + [What Didn't Go To Plan <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f44e.png?v8 width="30px">](#what-didn-t-go-to-plan)
  * [Possible Improvements For Future Revisions Of The Project <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4a1.png?v8 width="30px">](#possible-improvements-for-future-revisions-of-the-project)
  * [Postman Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4ee.png?v8 width="30px">](#postman-screenshots)

        * Post
        * Get After Post
        * Put
        * Get After Put
        * Delete
        * Get After Delete
        * Delete With No ID Of 1

  * [MySQL Workbench Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4bc.png?v8 width="30px">](#mysql-workbench-screenshots)

        * Schema
        * After Post
        * After Put
        * After Second Post
        * After Delete

  * [Testing Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f91e.png?v8 width="30px">](#testing-screenshots)
      - [Unit Testing](#unit-testing)
  
         * Service
         * Controller
         * Bonus - Entity
         
      - [Integration Testing](#integration-testing)

         * controller
         
      - [Combined testing](#combined-testing)
  * [Jira](#jira)
  * [Risk Assessment](#risk-assessment)


---
## <a name="why-did-we-do-this-project"></a> Why Did We Do This Project? <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f447.png?v8 width="30px">

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
## <a name="how-i-expected-the-project-to-go"></a> How I Expected The Project To Go? <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4aa.png?v8 width="30px">

Going into the project I was confident in creating the functionality (Entity, Repo, Service and Controller), this was because I already had a good understand of how to create these files. As a result of feeling confident I gave myself the challenge to have more fields, instead of the 2 or 3 like we had practiced as part of the training. By doing this I decided to implement the Builder Pattern, as this would allow me users more flexibility when it comes to creating and updating Medicine Objects. I also calculated that if I used the standard constructor methods I would need a total of 362,880 constructors to cover all potential field combination, therefore using the Builder Pattern would also make the code more manageable for me and more readable to anyone who wished to look at my program and use it.

I felt less confident about testing, especially using Mockito. This is something that I have been putting a lot of time into, but was struggling to full grasp why we use it. I could implement it and write the code to make it work, but I didn't have a full understanding of the tool. I will explain in the next section how I got on using it.

---
## <a name="what-went-well-and-what-didn-t-go-to-plan"></a> What Went Well and What Didn't Go To Plan?
### <a name="what-went-well"></a> What Went Well <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8 width="30px">
I managed to implement the functionality of the program and API without any flaws. I was able to complete all this code in a matter of hours, this was what I planned so that I would have as much time on testing as possible.

I was also able to move into the stretch goals by using Lombok to increase readability and accessibility.

In my planning stage I made the decision to ensure that each field in my Entity had adequate Javadoc's documentation, as some of the fields were very specialised and I wanted anyone to be able to full utilise my program and have minimal roadblocks to access. I was able to complete this within the time frame mentioned above.

### <a name="what-didn-t-go-to-plan"></a> What Didn't Go To Plan <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f44e.png?v8 width="30px">
As expected testing was a big topic when it came to my own knowledge and understanding. This meant that the timescale that I set had to be extended, this was greatly exacerbated by having a couple of day were I was not feeling well. After some trial and error, additional tutorial and self-lead research I now have a far better understanding of Mockito, and I believe that I would now be able to implement this style of testing more easily. This was evident as I manage to complete 3 of the tests quicker than expected.

Do to the ill-health mentioned above my overall timescale was extended, and I could not move onto the stretch goals as planned. This did not prevent me from completing the core MVP on time.

I also made some spelling mistakes when creating packages/directories, this lead to difficulties when trying to change them. I now know, and have saved the command ```git rm -rf --cache [file/dir]```.

The final problem I had was with regards to making the project executable. Within my testing I had accidently used both JUnit4 and JUnit5 components that were not compatible with each other. This meant changing some of the annotations, i.e. "@BeforeEach" to "@Before"

---
## <a name="possible-improvements-for-future-revisions-of-the-project"></a> Possible Improvements For Future Revisions Of The Project <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4a1.png?v8 width="30px">
I would like to extend the fields to include recommended dosages, wholesale prices and retail prices. After this I would want to create 3 DTO's that would like to 3 new Entities (Patient, Doctor and Pharmacy). This would allow for those that need to know different fields would have access to those fields and add an added layer of protection against some of the more sensitive information.

I would also like to add custom exception and increase the negative unit testing - I managed to include a few negative testing but I believe by adding more I would be able to give developers greater ease when using my API.

---
## <a name="postman-screenshots"></a> Postman Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4ee.png?v8 width="30px">
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

##### Delete With No ID Of 1
![Image showing Postman Get After Post](/images/Postman-delete_withNoId1.JPG)
---
## <a name="mysql-workbench-screenshot"></a> MySQL Workbench Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f4bc.png?v8 width="30px">
##### Schema
![Image showing Workbench schema](/images/Workbench-schema.JPG)

##### After Post
![Image showing Workbench After Post](/images/Workbench-afterPost.JPG)

##### After Put
![Image showing Workbench After Put](/images/Workbench-afterPut.JPG)

##### After Second Post
![Image showing Workbench After Second Post](/images/Workbench-after2Posts.JPG)

##### After Delete
![Image showing Workbench After Delete](/images/Workbench-afterDelete.JPG)

---
## <a name="testing-screenshot"></a> Testing Screenshots <img src=https://github.githubassets.com/images/icons/emoji/unicode/1f91e.png?v8 width="30px">

#### <a name="unit-testing"></a> Unit Testing
##### Service
![Image showing Unit Testing For Service](/images/UnitTest-service.JPG)

##### Controller
![Image showing Unit Testing For Controller](/images/UnitTest-Controller.JPG)

##### Bonus - Entity
![Image showing Unit Testing For Entity](/images/Test-entity.JPG)

#### <a name="integration-testing"></a> Integration Testing
##### Controller
![Image showing Integration Testing For Controller](/images/IntegrationTest-Controller.JPG)

#### Combined testing
![Image showing Combined Testing](/images/Test-combined.JPG)

## <a name="jira"></a> Jira
[My Jira Board](https://mrrbm97.atlassian.net/jira/software/projects/QPP/boards/1)

## <a name="risk-assessment"></a> Risk Assessment
[Risk Assessment](/documentation/RiskAssessment.pdf)

[Risk Matrix](/documentation/RiskMatrix.pdf)

## Acknowledgements
I thought it was important to acknowledge and thank those that helped me during the project, although it was my project; code and ideas I couldn't have completed it without the troubleshooting help when something went wrong. Therefore I want to thank:
- Trainers:
 - Anoush.
 - Pawel.
- Team mates:
 - Bal.
 - Keith.
 - Lukasz.

## Thank You For Checking Out My Repo!
