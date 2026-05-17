# Abstract 

Job seekers struggle to find relevant opportunities and employers face difficulties in finding suitable 
candidates. Traditional job platforms prioritize formal qualifications and hence creating a gap between 
potential employers and willing workers. To bridge this gap, we propose “Karya Space”, a user friendly 
website designed to connect individuals seeking work with employers offering jobs, empowering 
individuals, helping local businesses find reliable workers quickly, making the process quick, accessible, 
and efficient. The aim of this is to create a digital space where individuals looking for job and those 
offering jobs can interact easily.  
“Karya space” is a user-friendly website designed for both job seekers and employers. The name 
combines two meaningful words ‘Karya’, which means work, and ‘space’, which signifies a place or 
platform. Together, the name reflects the core purpose of the app: a dedicated space where people 
can find and offer work.  
The website works with features like location based search, profile matching system, chat system, 
rating system and an optional feature to identify the most compatible candidate through a Quick test 
. Instead of giving direct contact, the platform matches job seekers and employers based on location 
and profile. Both sides can rate each other, and only when they are comfortable, the chat option can 
be unlocked by the shopkeeper. For using the chat and accessing higher-rated candidates, the 
employer needs to pay a subscription fee, while job seekers can use the app for free. This makes the 
process easy, safe, and useful for both sides.  
To further expand its scope, Karya Space also includes a temporary and gig job mode, allowing 
employers to post short-term opportunities such as two-day sales events or weekend delivery tasks, 
enabling workers to earn flexibly through quick, short-term work. Moreover, the platform supports on
demand service booking, where users can hire skilled workers such as plumbers, electricians, or 
carpenters for a few hours to address urgent household or business needs.Once the worker 
successfully gets the job, the user updates their hiring status on the profile.  
By combining these features “Karya Space” creates a comprehensive, safe, and effective digital 
platform for employment. It empowers individuals to earn and grow, while enabling local businesses 
and households to find the right people without unnecessary struggles.

# Software Requirement Specification 

## 1.Introduction to Karya Space  

Karya Space is a user-friendly platform that connects local job seekers with employers, making hiring 
quick and simple. It supports full-time, part-time, and gig jobs while also allowing users to book skilled 
workers for urgent tasks, all through a safe and secure system.  

### 1.1 Purpose of the Requirements Documents  
The purpose of this Software Requirements Specification (SRS) document is to provide a detailed 
description of the functional and non-functional requirements for the Karya Space platform. It acts 
as a blueprint for the design, development, testing, and deployment processes. This document 
provides a structured framework to guide the project team throughout the development lifecycle, 
minimizing misunderstandings and ensuring the final product meets the desired objectives.  

### 1.2 Scope of the Product  
The platform’s primary focus is to simplify the hiring process by providing a centralized, safe, and 
efficient digital space where employers can find reliable workers and job seekers can discover 
relevant opportunities. The platform will include profile verification, location-based job matching, 
a matching algorithm based on backend logic, and a controlled communication system. The scope 
of Karya Space is to connect the employers and job seekers ,with the primary goal of addressing 
employment gaps in small businesses and community-driven jobs. 

### 1.3 References  
• IEEE Standard 830-1998: IEEE Recommended Practice for Software Requirements 
Specifications.  
• www.googleindia.com  
• https://www.naukri.com 
• https://www.linkedin.com 
• https://www.just.jobs 
• https://apna.co 
• https://www.workindia.in 
• https://www.urbancompany.com 

### 1.4 Overview of the Remainder of the Document  
This section provides a summary of the contents and structure of the remaining document. It helps 
readers understand how the Software Requirements Specification (SRS) is organized and what 
information to expect in each section. The document is structured to provide a comprehensive 
understanding of the Karya Space platform — from its general description and features to specific 
technical and functional requirements. 

#### 1. General Description: 
This part explains the overall perspective of the product. It describes how the Karya Space 
system fits into the current environment, the key features of the platform, types of users (job 
seekers, employers, and admins), general system constraints, and assumptions made during 
the design phase. 

#### 2. Functional Requirements: 
This section defines all major functionalities that the system will perform. It includes detailed 
descriptions of modules such as registration, login, job posting, chat system, profile 
matching, notification alerts, payment processing, subscription management, rating and 
review systems, and admin control. Each function includes input, processing, and output 
details. 

#### 3. External Interface Requirements: 
It describes how the system will interact with external entities. This includes: 
o User Interfaces (e.g., login page, dashboard, job posting page) 
o Hardware Interfaces (computers, smartphones, input/output devices) 
o Software Interfaces (operating systems, browsers, APIs, PDF Reader and databases) 
o Communication Interfaces (data transfer between frontend, backend, and external 
services). 

## 2 General Description  

### 2.1 Product perspective  
The platform will rely primarily on its own backend infrastructure during its initial. It will 
integrate with external services for specific functionalities like Cloud hosting and 
authentication using services like Firebase or AWS and Secure payment gateways for handling 
subscription fees. The platform will consist a web application , accessible across various 
devices, ensuring broad user accessibility.  

### 2.2 Product Functions  
• User Registration & Login – Allows job seekers and employers to create accounts and 
access the platform securely.  
• Profile Management – Users can create, update, and manage their personal or 
business profiles.  
• Job Posting & Management – Employers can post, edit, and remove job listings easily.  
• Job Search & Matching – Job seekers can search jobs by category, skills, and location; 
system suggests best matches.  
• Chat System – Enables secure communication between job seekers and employers 
after subscription activation.  
• Ratings & Reviews – Users can rate and review each other to build trust and 
credibility.  
• Subscription & Payment – Employers can pay for premium features such as chat 
unlock. 
• Notifications – Sends alerts for new jobs, messages, and application status updates.  
• On-Demand Services – Allows hiring skilled workers for short-term or urgent tasks. 

### 2.3 User Characteristics  
• Job Seekers  
➢ These are local people looking for jobs in their nearby area. 
➢  They can use the app to create their profile, search for jobs, and apply 
for them.  
➢ They will get job alerts and can update their status once they are hired. 
➢ The platform is simple so that anyone can use it easily without any 
difficulty.  
• Employers / Job Providers 
➢ These are shopkeepers, small business owners, or individuals who need 
workers.  
➢ They can post jobs with details like work type, location, and timing.  
➢ The system will automatically match suitable job seekers based on their 
profiles and show employers the most relevant candidates.  
➢ They can use the chat option (after subscription) to communicate with job 
seekers.  
• Admin Users  
➢ These are the people who manage the platform.  
➢ They approve job posts, verify users, and keep the platform safe. 
➢ They can remove fake or wrong job posts and solve user complaints. 

### 2.4. General Constraints  
• Internet Connection Required – The platform works only when there is an active internet 
connection.  
• Device Compatibility – The platform should work on Android and web browser.  
• Secure Data Handling – All user data must be stored safely and used only for matching jobs.  
• Subscription System – Some features like chat unlock are available only after the employer 
pays for a subscription.  
• Server Availability – The system depends on servers being online 24×7 for smooth job 
matching and communication.  
2. 5.Assumptions and Dependencies  
• Third-Party Services Work Properly – The platform depends on services like Payment Gateway 
(for subscriptions) to work without failure.  
• Cloud Server Availability – The system assumes that the cloud servers will stay online and 
responsive for smooth operations.  
• User Engagement – It is assumed that users will regularly check notifications and respond to 
job offers quickly.  
• Legal Compliance – The platform depends on following data privacy and local employment 
regulations to stay safe legally.

# .Functional Requirements 

## Functional Requirement 1 : Job Seeker Registration 

Inputs: 
• Name 
• E-mail 
•  Phone 
• Password 
• Address 
• Aadhar no 

Processing: 
• Validate mandatory fields 
• Check if email/phone already exists 
• Encrypt password 
• Store user details in database 

Output: 
• Generated Job Seeker User ID 
• Registration success message 
## Functional Requirement 2 : Employer Registration

Inputs: 
• Organization/Business Name 
• E-mail 
• Phone 
• Password 
• Business Category 
• Location 

Processing: 
• Validate required details 
• Verify email/phone uniqueness 
• Encrypt password 
• Save employer profile in database
 
Output: 
• Generated Employer User ID 
• Registration success message 

## Functional Requirement 3 : Admin Registration 

Inputs: 
• Admin Name 
• E-mail 
• Phone 
• Password 
• Admin Role Type 

Processing: 
• Verify authorization key to create admin 
• Validate fields 
• Encrypt password 
• Insert admin record in database 

Output: 
• Generated Admin User ID 

## Functional Requirement 4 : Login Authentication 

Inputs: 
• E-mail/Phone 
• Password 

Processing: 
• Match login credentials 
• Validate user role (job seeker / employer / admin) 

Output: 
• Login success message 
• Redirect to respective dashboard 

## Functional Requirement 5 :  Profile Creation (Job Seeker) 

Inputs: 
• Profile Pic 
• Skills 
• Experience 
• Resume 
• Location 
• Preferred Job Category  
• Preferred Job Type 

Processing: 
• Validate uploaded resume format 
• Store profile data 
• Update job seeker database record 

Output: 
• Profile created confirmation 

## Functional Requirement 6 : Profile Creation (Employer) 

Inputs: 
• Company Description 
• Services Offered 
• Logo Upload 
• Address 

Processing: 
• Validate company details 
• Upload logo to server 
• Save employer profile 

Output: 
• Employer profile creation success 

## Functional Requirement 7 : Profile Management (Employer/Jobseeker) 

Inputs: 
• Updated user details 
• New skills or certifications 
• Profile picture uploads 

Processing: 
• Check input validity 
• Update database fields 
• Refresh user profile 

Output: 
• Updated profile confirmation 

## Functional Requirement 8 :Job Posting (Including Gig Jobs) 

Inputs: 
• Job Title 
• Job Description 
• Required Skills 
• Job Duration 
• Salary 
• Gig Category 

Processing: 
• Validate job details 
• Tag job category (full-time/part-time/gig) 
• Store job post in database 

Output: 
• Job Post ID generated 
• Job posted successfully

## Functional Requirement 9 : On-Demand Service Booking  

Inputs: 
• Service Type (plumber, electrician, carpenter, etc.) 
• User Location 
• Time Slot 
• Service Description 

Processing: 
• Match service provider based on location 
• Check availability 
• Confirm booking 

Output: 
• Assigned Service Provider Details 

## Functional Requirement 10 : Search Jobs / Search Services 

Inputs: 
• Keywords 
• Location 
• Skill/Service Type 
• Category 

Processing: 
• Validate matching records using filters 
• Rank results using relevance algorithm 

Output: 
• List of matching jobs/services 

## Functional Requirement 11 : Profile Matching System 

Inputs: 
• Job Seeker’s Skills, Job Seeker’s Job Category, Job Seeker’s Location 
• Employer’s Required Skills, Employer’s Job Category, Employer’s Location 

Processing: 
• Compare job seeker skills with required employer’skills 
• Filter by location 
• Sort by Rating 

Output: 
• Matched Profiles List 

## Functional Requirement 12 : Job Application Submission 

Inputs: 
• Job Post ID 
• Job Seeker ID 
• Resume or Profile 

Processing: 
• Validate application 
• Link application to job post record 
• Notify employer 

Output: 
• Application confirmation ID 

## Functional Requirement 13 : Employer Shortlisting 

Inputs: 
• List of applicants 
• Employer selection manually 

Processing: 
• Save shortlisted candidates 

Output: 
• Shortlist generated message 
• Show hiring status on Jobseeker’s ID 

## Functional Requirement 14 :Chat System 

Inputs: 
• Message from sender with Timestamp 
• Receiver ID 
• Sender ID 

Processing: 
• Validate user authentication 
• Store message in encrypted format 
• Deliver message in real-time 

Output: 
• Sent message confirmation 
• Notification to Reciever 

## Functional Requirement 15 : Quick Test Formation 

Inputs: 
• Employer ID 
• Questions(MCQ’s) with Answers 
• Skills to Test 

Processing: 
• Auto-generate test pattern 
• Save test template 

Output: 
• Generated Test ID 

## Functional Requirement 16 : Quick Test Selection (Optional) 

Inputs: 
• Available Quick Test ID’s 
• Selected Test ID

Processing: 
• Validate test details 
• Assign selected test to candidate 
Output: 

• Test selection confirmation 

## Functional Requirement 17 :  Test Attempt & Evaluation 

Inputs: 
• Jobseeker ID 
• Candidate’s answers 
• Test ID

Processing: 
• Auto-evaluate objective answers 
• Calculate score 
• Generate result 

Output: 
• Test Result/Score 

## Functional Requirement 18 : Notification & Alerts 

Inputs: 
• Trigger events (job post, application update, message, booking) 

Processing: 
• Check type of event 
• Send notification (email/app) 

Output:  
• Notification received by user 

## Functional Requirement 19 : Subscription (For Services or Premium Jobs)

Inputs: 
• Payment ID 
• Amount 
• Employer ID 
• Subscription ID 

Processing: 
• Validate transaction 
• Process through payment gateway 
• Generate invoice 

Output: 
• Payment Status 
• If Payment confirmed, Chat unlocked 

## Functional Requirement 20 :  Rating & Review System 

Inputs: 
• Rating (1–5 stars) 
• Written Review (text) 
• Job/Service ID 
• Rated User ID (Job Seeker or Service Provider) 

Processing: 
• Validate rating range (1–5) 
• Validate text review 
• First three ratings for any new user go into probation mode. 
• During probation, ratings are stored but not publicly displayed. 
• Once 3 ratings are collected, Calculate the average rating & display it on the user’s profile. 
• After probation, new ratings update the normal average. 
• Save written review 
• Associate review with user profile 

Outputs: 
• Rating submission confirmation 
• Display text review  
• If user completes probation: “Star Rating Now Visible on Profile” 
• Updated rating score on profile (after probation) 

## Functional Requirement 21 : App Feedback System 

Inputs: 
• JobSeeker ID/Employer ID 
• User Feedback (text) 
• Optional Screenshot or Attachment 

Processing: 
• Validate feedback text 
• Forward urgent issues (e.g., bugs) to admin panel 

Outputs: 
• Feedback Submission Confirmation 
• “Thank you for improving the app” message 

## Functional Requirement 22: Security & Privacy Management 

Inputs: 
• User login credentials (email/phone, password/OTP) 
• Sensitive user data (profiles, messages,  verification documents) 
• Job post details for verification 
• User complaints/reports 
• System activity logs(login attempts ,job edits ,chat activity, errors) 

Processing: 
• Validate user identity through secure authentication (password hashing, OTP checks) 
• Verify user identity and job post authenticity 
• Encrypt sensitive data during storage and transmission 
• Record,categorize, and forward complaints to admin 
• Monitor system activity for unauthorized access or unusual behavior 

Outputs: 
• Secure and verified user access 
• Job post approval or rejection messages 
• Alerts for suspicious system activity 
• Complaint acknowledgement and resolution update
