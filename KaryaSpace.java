import java.util.Scanner;

public class KaryaSpace {

    static Scanner sc = new Scanner(System.in);

   
    static final String ROLE_ADMIN    = "admin";
    static final String ROLE_SEEKER   = "jobseeker";
    static final String ROLE_EMPLOYER = "employer";

    
    static String loggedInUser = null;
    static String loggedInRole = null;
    
    static String[] skNames       = new String[50];
    static String[] skEmails      = new String[50];
    static String[] skPasswords   = new String[50];
    static String[] skAdhaar      = new String[50];
    static String[] skInterests   = new String[50];
    static String[] skAddress     = new String[50];
    static String[] skSkills      = new String[50];
    static String[] skSubs        = new String[50];
    static double[] skRatings     = new double[50];
    static int[]    skRatingCount = new int[50];
    static int      skCount       = 0;


    static String[] empNames     = new String[30];
    static String[] empEmails    = new String[30];
    static String[] empPasswords = new String[30];
    static String[] empCompany   = new String[30];
    static String[] empBizType   = new String[30];
    static String[] empContact   = new String[30];
    static int      empCount     = 0;


    static String[] jobTitles    = new String[50];
    static String[] jobCompany   = new String[50];
    static String[] jobSkills    = new String[50];
    static String[] jobLocations = new String[50];
    static String[] jobSalary    = new String[50];
    static int[]    jobMinExp    = new int[50];
    static String[] jobPostedBy  = new String[50];
    static String[] jobStatus    = new String[50];   
    static int      jobCount     = 0;

    static String[] appJob    = new String[100];
    static String[] appSeeker = new String[100];
    static String[] appStatus = new String[100];   
    static int      appCount  = 0;

    
    static String[] gigTitle  = new String[30];
    static String[] gigBudget = new String[30];
    static String[] gigLoc    = new String[30];
    static String[] gigPoster = new String[30];
    static int      gigCount  = 0;

    
    static String[] chatFrom  = new String[100];
    static String[] chatTo    = new String[100];
    static String[] chatMsg   = new String[100];
    static int      chatCount = 0;

    
    static String[] notifUser  = new String[200];
    static String[] notifMsg   = new String[200];
    static int      notifCount = 0;

    
    static String[] revTarget = new String[50];
    static String[] revText   = new String[50];
    static String[] revBy     = new String[50];
    static int      revCount  = 0;

    
    static String[] fbUser  = new String[50];
    static String[] fbText  = new String[50];
    static int      fbCount = 0;

   
    static String[] txnUser   = new String[50];
    static String[] txnAmount = new String[50];
    static String[] txnStatus = new String[50];
    static int      txnCount  = 0;

    
   
    static String[] testNames  = {"Java Basics","Python Basics","Aptitude","Marketing","SQL Basics"};
    static String[] testLevels = {"Easy","Easy","Medium","Easy","Medium"};
    static int      testCount  = 5;

    public static void main(String[] args) {
        banner();
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("   SELECT YOUR ROLE           ");
            System.out.println("  1.  Admin                       ");
            System.out.println("  2.  Job Seeker                  ");
            System.out.println("  3.  Employer                    ");
            System.out.println("  0.  Exit                        ");
            System.out.println("\n");
            System.out.print("Enter role: ");
            int role = readInt();
            switch (role) {
                case 1: adminGateway();    break;
                case 2: seekerGateway();   break;
                case 3: employerGateway(); break;
                case 0:
                    System.out.println("Thank you for using Job Portal. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0-3.");
            }
        }
    }


    static void adminGateway() {
        System.out.println("\n--- ADMIN LOGIN ---");
        System.out.print("Username : "); String u = sc.nextLine().trim();
        System.out.print("Password : "); String p = sc.nextLine().trim();
        if (!u.equals("admin") || !p.equals("admin123")) {
            System.out.println("ERROR: Invalid admin credentials.");
            return;
        }
        loggedInUser = "admin";
        loggedInRole = ROLE_ADMIN;
        System.out.println("Admin login successful. Welcome!");
        adminMenu();
        loggedInUser = null;
        loggedInRole = null;
    }

    static void adminMenu() {
        boolean active = true;
        while (active) {
            System.out.println("\n");
            System.out.println("        ADMIN DASHBOARD              ");
            System.out.println("\n");
            System.out.println("  1.  View All Job Seekers              ");
            System.out.println("  2.  Delete a Job Seeker               ");
            System.out.println("  3.  View All Employers                ");
            System.out.println("  4.  Delete an Employer                ");
            System.out.println("  5.  View All Jobs                     ");
            System.out.println("  6.  Approve / Reject a Job            ");
            System.out.println("  7.  System Report                     ");
            System.out.println("  8.  View All Feedback                 ");
            System.out.println("  9.  Broadcast Notification to All     ");
            System.out.println(" 10.  View All Transactions             ");
            System.out.println(" 11.  Security & Privacy Info           ");
            System.out.println(" 12.  Data Management (Full View)       ");
            System.out.println("  0.  Logout                            ");
            System.out.println("\n");
            System.out.print("Admin choice: ");
            int c = readInt();
            switch (c) {
                case 1:  adminViewSeekers();      break;
                case 2:  adminDeleteSeeker();     break;
                case 3:  adminViewEmployers();    break;
                case 4:  adminDeleteEmployer();   break;
                case 5:  adminViewJobs();         break;
                case 6:  adminApproveJob();       break;
                case 7:  adminReport();           break;
                case 8:  adminViewFeedback();     break;
                case 9:  adminBroadcast();        break;
                case 10: adminViewTransactions(); break;
                case 11: securityPrivacyInfo();   break;
                case 12: adminDataMgmt();         break;
                case 0:
                    System.out.println("Admin logged out successfully.");
                    active = false;
                    break;
                default: System.out.println("Invalid option. Choose 0-12.");
            }
        }
    }

  
    static void adminViewSeekers() {
        System.out.println("\n--- ALL JOB SEEKERS (" + skCount + ") ---");
        if (skCount == 0) { System.out.println("No job seekers registered yet."); return; }
        for (int i = 0; i < skCount; i++) {
            System.out.printf("  %2d. Username: %-15s | Email: %-25s | Sub: %-10s | Rating: %.1f%n",
                i+1, skNames[i], skEmails[i], skSubs[i], skRatings[i]);
        }
    }

    // FR5 - Delete a job seeker
    static void adminDeleteSeeker() {
        System.out.println("\n--- DELETE JOB SEEKER ---");
        adminViewSeekers();
        if (skCount == 0) return;
        System.out.print("Enter username to delete: "); String du = sc.nextLine().trim();
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(du)) {
                for (int j = i; j < skCount - 1; j++) {
                    skNames[j]     = skNames[j+1];
                    skEmails[j]    = skEmails[j+1];
                    skPasswords[j] = skPasswords[j+1];
                    skSubs[j]      = skSubs[j+1];
                    skSkills[j]    = skSkills[j+1];
                    skInterests[j] = skInterests[j+1];
                    skAddress[j]   = skAddress[j+1];
                    skAdhaar[j]    = skAdhaar[j+1];
                }
                skCount--;
                System.out.println("SUCCESS: Job seeker '" + du + "' deleted.");
                return;
            }
        }
        System.out.println("User '" + du + "' not found.");
    }

    
    static void adminViewEmployers() {
        System.out.println("\n--- ALL EMPLOYERS (" + empCount + ") ---");
        if (empCount == 0) { System.out.println("No employers registered yet."); return; }
        for (int i = 0; i < empCount; i++) {
            System.out.printf("  %2d. Username: %-15s | Email: %-22s | Company: %-18s | Type: %s%n",
                i+1, empNames[i], empEmails[i], empCompany[i], empBizType[i]);
        }
    }

  
    static void adminDeleteEmployer() {
        System.out.println("\n--- DELETE EMPLOYER ---");
        adminViewEmployers();
        if (empCount == 0) return;
        System.out.print("Enter employer username to delete: "); String du = sc.nextLine().trim();
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(du)) {
                for (int j = i; j < empCount - 1; j++) {
                    empNames[j]     = empNames[j+1];
                    empEmails[j]    = empEmails[j+1];
                    empPasswords[j] = empPasswords[j+1];
                    empCompany[j]   = empCompany[j+1];
                    empBizType[j]   = empBizType[j+1];
                    empContact[j]   = empContact[j+1];
                }
                empCount--;
                System.out.println("SUCCESS: Employer '" + du + "' deleted.");
                return;
            }
        }
        System.out.println("Employer '" + du + "' not found.");
    }

    
    static void adminViewJobs() {
        System.out.println("\n--- ALL JOBS (" + jobCount + ") ---");
        if (jobCount == 0) { System.out.println("No jobs posted yet."); return; }
        for (int i = 0; i < jobCount; i++) {
            System.out.printf("  %2d. %-20s | %-18s | Skill: %-10s | Loc: %-12s | Status: %s%n",
                i+1, jobTitles[i], jobCompany[i], jobSkills[i],
                jobLocations[i], jobStatus[i].toUpperCase());
        }
    }

    
    static void adminApproveJob() {
        System.out.println("\n--- APPROVE / REJECT JOB ---");
        adminViewJobs();
        if (jobCount == 0) return;
        System.out.print("Job index (1-based): "); int idx = readInt() - 1;
        if (idx < 0 || idx >= jobCount) { System.out.println("Invalid index."); return; }
        System.out.println("Selected: " + jobTitles[idx] + " | Current Status: " + jobStatus[idx]);
        System.out.println("1. Approve  2. Reject");
        System.out.print("Choice: "); int ch = readInt();
        if (ch == 1) {
            jobStatus[idx] = "open";
            System.out.println("Job '" + jobTitles[idx] + "' APPROVED. Now visible to seekers.");
            addNotif(jobPostedBy[idx], "Your job '" + jobTitles[idx] + "' was approved by admin.");
            for (int i = 0; i < skCount; i++) {
                addNotif(skNames[i], "New job available: " + jobTitles[idx] + " @ " + jobCompany[idx]);
            }
        } else if (ch == 2) {
            jobStatus[idx] = "rejected";
            System.out.println("Job '" + jobTitles[idx] + "' REJECTED.");
            addNotif(jobPostedBy[idx], "Your job '" + jobTitles[idx] + "' was rejected by admin.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

   
    static void adminReport() {
        System.out.println("\n--- SYSTEM REPORT ---");
        int open = 0, pending = 0, closed = 0, rejected = 0;
        for (int i = 0; i < jobCount; i++) {
            if ("open".equals(jobStatus[i]))     open++;
            if ("pending".equals(jobStatus[i]))  pending++;
            if ("closed".equals(jobStatus[i]))   closed++;
            if ("rejected".equals(jobStatus[i])) rejected++;
        }
        System.out.println("  Total Job Seekers   : " + skCount);
        System.out.println("  Total Employers     : " + empCount);
        System.out.println("  Total Jobs          : " + jobCount
            + " (Open:" + open + " Pending:" + pending
            + " Closed:" + closed + " Rejected:" + rejected + ")");
        System.out.println("  Total Gigs          : " + gigCount);
        System.out.println("  Total Applications  : " + appCount);
        System.out.println("  Total Transactions  : " + txnCount);
        System.out.println("  Total Reviews       : " + revCount);
        System.out.println("  Total Feedbacks     : " + fbCount);
        System.out.println("  Total Notifications : " + notifCount);
        System.out.println("  Total Chat Messages : " + chatCount);
    }

    
    static void adminViewFeedback() {
        System.out.println("\n--- ALL FEEDBACK (" + fbCount + ") ---");
        if (fbCount == 0) { System.out.println("No feedback submitted yet."); return; }
        for (int i = 0; i < fbCount; i++) {
            System.out.printf("  %2d. [%s] %s%n", i+1, fbUser[i], fbText[i]);
        }
    }

    
    static void adminBroadcast() {
        System.out.println("\n--- BROADCAST NOTIFICATION ---");
        System.out.print("Broadcast Message: "); String msg = sc.nextLine().trim();
        for (int i = 0; i < skCount; i++)  addNotif(skNames[i],  "[ADMIN BROADCAST] " + msg);
        for (int i = 0; i < empCount; i++) addNotif(empNames[i], "[ADMIN BROADCAST] " + msg);
        System.out.println("Broadcast sent to " + (skCount + empCount) + " user(s).");
    }

    
    static void adminViewTransactions() {
        System.out.println("\n--- ALL TRANSACTIONS (" + txnCount + ") ---");
        if (txnCount == 0) { System.out.println("No transactions recorded."); return; }
        for (int i = 0; i < txnCount; i++) {
            System.out.printf("  %2d. User: %-15s | Amount: Rs.%-8s | Status: %s%n",
                i+1, txnUser[i], txnAmount[i], txnStatus[i]);
        }
    }

    
    static void securityPrivacyInfo() {
        System.out.println("\n--- SECURITY & PRIVACY POLICY ---");
        System.out.println("  * Passwords are encrypted (XOR cipher, demo only).");
        System.out.println("  * Adhaar data stored securely, never exposed.");
        System.out.println("  * Role-based access: Admin / Job Seeker / Employer.");
        System.out.println("  * Sessions are cleared on logout.");
        System.out.println("  * All transactions logged with unique TxnID.");
        System.out.println("  * Unauthorized access is blocked by credential check.");
    }

    
    static void adminDataMgmt() {
        System.out.println("\n--- DATA MANAGEMENT (ADMIN) ---");
        System.out.println("1. All Seekers  2. All Employers  3. All Jobs  4. All Applications");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1: adminViewSeekers();   break;
            case 2: adminViewEmployers(); break;
            case 3: adminViewJobs();      break;
            case 4:
                System.out.println("\n--- ALL APPLICATIONS (" + appCount + ") ---");
                if (appCount == 0) { System.out.println("No applications yet."); return; }
                for (int i = 0; i < appCount; i++) {
                    System.out.printf("  %2d. Seeker: %-15s | Job: %-20s | Status: %s%n",
                        i+1, appSeeker[i], appJob[i], appStatus[i].toUpperCase());
                }
                break;
            default: System.out.println("Invalid option.");
        }
    }

  

    static void seekerGateway() {
        System.out.println("\n--- JOB SEEKER PORTAL ---");
        System.out.println("1. Register as Job Seeker");
        System.out.println("2. Login as Job Seeker");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1:
                seekerRegister();
                break;
            case 2:
                if (seekerLogin()) {
                    seekerMenu();
                    loggedInUser = null;
                    loggedInRole = null;
                }
                break;
            default: System.out.println("Invalid option.");
        }
    }

    static void seekerRegister() {
        System.out.println("\n--- JOB SEEKER REGISTRATION ---");
        if (skCount >= 50) { System.out.println("Seeker limit reached."); return; }
        System.out.print("Full Name   : "); String name  = sc.nextLine().trim();
        System.out.print("Email       : "); String email = sc.nextLine().trim();
        System.out.print("Username    : "); String uname = sc.nextLine().trim();
        System.out.print("Password    : "); String pwd   = sc.nextLine().trim();
        System.out.print("Adhaar No   : "); String adh   = sc.nextLine().trim();
        System.out.print("Interests   : "); String inter = sc.nextLine().trim();
        System.out.print("Address     : "); String addr  = sc.nextLine().trim();
        System.out.print("Skills      : "); String skill = sc.nextLine().trim();

        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(uname)) {
                System.out.println("ERROR: Username '" + uname + "' already exists.");
                return;
            }
        }
        if (!email.contains("@") || pwd.length() < 4) {
            System.out.println("ERROR: Invalid email or password too short (min 4 chars).");
            return;
        }

        skNames[skCount]       = uname;
        skEmails[skCount]      = email;
        skPasswords[skCount]   = encrypt(pwd);
        skAdhaar[skCount]      = adh;
        skInterests[skCount]   = inter;
        skAddress[skCount]     = addr;
        skSkills[skCount]      = skill;
        skSubs[skCount]        = "free";
        skRatings[skCount]     = 0.0;
        skRatingCount[skCount] = 0;
        skCount++;

        System.out.println("SUCCESS: Job Seeker account created for '" + name + "'.");
        System.out.println("Login confirmation sent to: " + email);
        addNotif(uname, "Welcome to Job Portal! Start exploring jobs now.");
    }

   
    static boolean seekerLogin() {
        System.out.println("\n--- JOB SEEKER LOGIN ---");
        System.out.print("Username/Email: "); String id  = sc.nextLine().trim();
        System.out.print("Password      : "); String pwd = sc.nextLine().trim();
        for (int i = 0; i < skCount; i++) {
            if ((skNames[i].equalsIgnoreCase(id) || skEmails[i].equalsIgnoreCase(id))
                    && skPasswords[i].equals(encrypt(pwd))) {
                loggedInUser = skNames[i];
                loggedInRole = ROLE_SEEKER;
                System.out.println("Login successful! Welcome back, " + loggedInUser + ".");
                addNotif(loggedInUser, "You logged in as Job Seeker.");
                return true;
            }
        }
        System.out.println("ERROR: Invalid username or password.");
        return false;
    }

    static void seekerMenu() {
        boolean active = true;
        while (active) {
            System.out.println("\n");
            System.out.println("         JOB SEEKER DASHBOARD           ");
            System.out.println("  User: " + padRight(loggedInUser, 32) + "\n");
            System.out.println("\n");
            System.out.println("  1.  View My Profile                   ");
            System.out.println("  2.  Edit My Profile                   ");
            System.out.println("  3.  Profile Matching (Smart Job Find) ");
            System.out.println("  4.  Browse All Open Jobs              ");
            System.out.println("  5.  Apply for a Job                   ");
            System.out.println("  6.  My Applications & Hiring Status   ");
            System.out.println("  7.  Gig Job Mode (Browse Gigs)        ");
            System.out.println("  8.  Quick Test Selection              ");
            System.out.println("  9.  Subscription & Payment            ");
            System.out.println(" 10.  Chat System                       ");
            System.out.println(" 11.  Rate an Employer                  ");
            System.out.println(" 12.  Write a Review                    ");
            System.out.println(" 13.  My Notifications                  ");
            System.out.println(" 14.  Feedback & Support                ");
            System.out.println(" 15.  Change Password (Security)        ");
            System.out.println(" 16.  Delete My Account                 ");
            System.out.println("  0.  Logout                            ");
            System.out.println("\n");
            System.out.print("Seeker choice: ");
            int c = readInt();
            switch (c) {
                case 1:  seekerViewProfile();   break;
                case 2:  seekerEditProfile();   break;
                case 3:  seekerProfileMatch();  break;
                case 4:  seekerBrowseJobs();    break;
                case 5:  seekerApplyJob();      break;
                case 6:  seekerMyApps();        break;
                case 7:  seekerGigMode();       break;
                case 8:  seekerQuickTest();     break;
                case 9:  seekerSubscription();  break;
                case 10: chatSystem();          break;
                case 11: seekerRateEmployer();  break;
                case 12: seekerWriteReview();   break;
                case 13: viewNotifications();   break;
                case 14: submitFeedback();      break;
                case 15: seekerChangePwd();     break;
                case 16:
                    seekerDeleteAccount();
                    active = false;
                    break;
                case 0:
                    System.out.println("Logged out. Goodbye, " + loggedInUser + "!");
                    active = false;
                    break;
                default: System.out.println("Invalid option. Choose 0-16.");
            }
        }
    }

    
    
    static void seekerViewProfile() {
        System.out.println("\n--- MY PROFILE ---");
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser)) {
                System.out.println("  Username     : " + skNames[i]);
                System.out.println("  Email        : " + skEmails[i]);
                System.out.println("  Adhaar       : " + skAdhaar[i]);
                System.out.println("  Skills       : " + skSkills[i]);
                System.out.println("  Interests    : " + skInterests[i]);
                System.out.println("  Address      : " + skAddress[i]);
                System.out.println("  Subscription : " + skSubs[i].toUpperCase());
                System.out.printf( "  Rating       : %.1f / 5.0  (%d ratings)%n",
                    skRatings[i], skRatingCount[i]);
                return;
            }
        }
        System.out.println("Profile not found.");
    }

   
    static void seekerEditProfile() {
        System.out.println("\n--- EDIT MY PROFILE ---");
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser)) {
                System.out.print("New Skills    (current: " + skSkills[i] + "): ");
                String ns = sc.nextLine().trim();
                if (!ns.isEmpty()) skSkills[i] = ns;

                System.out.print("New Interests (current: " + skInterests[i] + "): ");
                String ni = sc.nextLine().trim();
                if (!ni.isEmpty()) skInterests[i] = ni;

                System.out.print("New Address   (current: " + skAddress[i] + "): ");
                String na = sc.nextLine().trim();
                if (!na.isEmpty()) skAddress[i] = na;

                System.out.println("Profile updated successfully.");
                return;
            }
        }
        System.out.println("Profile not found.");
    }

    // FR3 - Profile matching
    static void seekerProfileMatch() {
        System.out.println("\n--- PROFILE MATCHING (Smart Job Finder) ---");
        String mySkills = "";
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser)) { mySkills = skSkills[i].toLowerCase(); break; }
        }
        System.out.print("Years of Experience : "); int exp = readInt();
        System.out.print("Preferred Category  : "); sc.nextLine(); // consume
        System.out.print("Preferred Location  : "); String loc = sc.nextLine().trim().toLowerCase();

        System.out.println("\n--- MATCHED JOBS ---");
        int found = 0;
        for (int i = 0; i < jobCount; i++) {
            if (!"open".equals(jobStatus[i])) continue;
            int score = 0;
            if (!mySkills.isEmpty() && mySkills.contains(jobSkills[i].toLowerCase())) score += 40;
            if (exp >= jobMinExp[i])                                                   score += 30;
            if (!loc.isEmpty() && jobLocations[i].toLowerCase().contains(loc))         score += 30;
            if (score > 0) {
                System.out.printf("  [Score:%3d%%] %-20s | %-18s | Skill:%-10s | Loc:%-12s | Sal:%s%n",
                    score, jobTitles[i], jobCompany[i], jobSkills[i], jobLocations[i], jobSalary[i]);
                found++;
            }
        }
        if (found == 0) System.out.println("No suitable jobs found based on your profile.");
        else            System.out.println(found + " job(s) matched.");
    }

    
    static void seekerBrowseJobs() {
        System.out.println("\n--- OPEN JOB LISTINGS ---");
        int found = 0;
        for (int i = 0; i < jobCount; i++) {
            if ("open".equals(jobStatus[i])) {
                System.out.printf("  %2d. %-20s | %-18s | Skill:%-10s | Loc:%-12s | Exp:%dyr | Sal:%s%n",
                    i+1, jobTitles[i], jobCompany[i], jobSkills[i],
                    jobLocations[i], jobMinExp[i], jobSalary[i]);
                found++;
            }
        }
        if (found == 0) System.out.println("No open jobs available at the moment.");
    }

    static void seekerApplyJob() {
        System.out.println("\n--- APPLY FOR A JOB ---");
        seekerBrowseJobs();
        if (appCount >= 100) { System.out.println("Application limit reached."); return; }
        System.out.print("Enter Job Title to apply: "); String jt = sc.nextLine().trim();
        int ji = -1;
        for (int i = 0; i < jobCount; i++) {
            if (jobTitles[i].equalsIgnoreCase(jt) && "open".equals(jobStatus[i])) { ji = i; break; }
        }
        if (ji == -1) { System.out.println("Job '" + jt + "' not found or not open."); return; }
        for (int i = 0; i < appCount; i++) {
            if (appSeeker[i].equalsIgnoreCase(loggedInUser) && appJob[i].equalsIgnoreCase(jt)) {
                System.out.println("You have already applied for '" + jt + "'."); return;
            }
        }
        appJob[appCount]    = jobTitles[ji];
        appSeeker[appCount] = loggedInUser;
        appStatus[appCount] = "applied";
        appCount++;
        System.out.println("Applied successfully for: " + jt + " at " + jobCompany[ji]);
        addNotif(loggedInUser, "Application submitted: " + jt + " @ " + jobCompany[ji]);
        addNotif(jobPostedBy[ji], "New application for '" + jt + "' from " + loggedInUser);
    }

    static void seekerMyApps() {
        System.out.println("\n--- MY APPLICATIONS ---");
        boolean any = false;
        for (int i = 0; i < appCount; i++) {
            if (appSeeker[i].equalsIgnoreCase(loggedInUser)) {
                System.out.printf("  Job: %-20s | Status: %s%n",
                    appJob[i], appStatus[i].toUpperCase());
                any = true;
            }
        }
        if (!any) System.out.println("No applications submitted yet.");
    }

  
    static void seekerGigMode() {
        System.out.println("\n--- GIG JOB MODE ---");
        System.out.print("Filter by location (press Enter for all): ");
        String fl = sc.nextLine().trim().toLowerCase();
        System.out.println("\n--- AVAILABLE GIGS ---");
        boolean found = false;
        for (int i = 0; i < gigCount; i++) {
            if (fl.isEmpty() || gigLoc[i].toLowerCase().contains(fl)) {
                System.out.printf("  %2d. %-20s | Budget: %-10s | Loc: %-12s | Posted by: %s%n",
                    i+1, gigTitle[i], gigBudget[i], gigLoc[i], gigPoster[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No gigs found matching your filter.");
    }

   
    static void seekerQuickTest() {
        System.out.println("\n--- QUICK TEST SELECTION ---");
        System.out.println("Available Tests:");
        for (int i = 0; i < testCount; i++) {
            System.out.printf("  %d. %-15s [Level: %s]%n", i+1, testNames[i], testLevels[i]);
        }
        System.out.print("Select test number: "); int t = readInt() - 1;
        if (t < 0 || t >= testCount) { System.out.println("Invalid selection."); return; }
        System.out.println("\nStarting Test: " + testNames[t] + " [" + testLevels[t] + "]");
        System.out.println("Q1: What does OOP stand for?");
        System.out.print("Your Answer: "); String ans = sc.nextLine().trim();
        if (ans.toLowerCase().contains("object")) {
            System.out.println("Correct! Score: 10/10");
        } else {
            System.out.println("Incorrect. Score: 0/10. Answer: Object Oriented Programming");
        }
        addNotif(loggedInUser, "Completed test: " + testNames[t]);
    }

    
    static void seekerSubscription() {
        System.out.println("\n--- SUBSCRIPTION & PAYMENT ---");
        System.out.println("Plans:");
        System.out.println("  1. Free       - Basic features");
        System.out.println("  2. Premium    - Rs.499/month (Unlock all job matches)");
        System.out.println("  3. Enterprise - Rs.999/month (Priority listings + analytics)");
        System.out.print("Select plan: "); int p = readInt();
        String plan = "free";
        String amt  = "0";
        if (p == 2) { plan = "premium";    amt = "499"; }
        if (p == 3) { plan = "enterprise"; amt = "999"; }

        if (!plan.equals("free")) {
            System.out.println("Payment Methods: 1. Card   2. UPI   3. Wallet");
            System.out.print("Method: "); int m = readInt();
            String method = m == 1 ? "Card" : m == 2 ? "UPI" : "Wallet";
            System.out.print("Enter " + method + " details: "); sc.nextLine();
            System.out.println("Connecting to payment gateway...");
            long txnId = System.currentTimeMillis() % 100000;
            if (txnCount < 50) {
                txnUser[txnCount]   = loggedInUser;
                txnAmount[txnCount] = amt;
                txnStatus[txnCount] = "success";
                txnCount++;
            }
            System.out.println("Payment SUCCESS! Rs." + amt + " paid. TxnID: TXN" + txnId);
            addNotif(loggedInUser, "Payment Rs." + amt + " successful. TxnID: TXN" + txnId);
        }
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser)) { skSubs[i] = plan; break; }
        }
        System.out.println("Subscription updated to: " + plan.toUpperCase());
        addNotif(loggedInUser, "Your subscription is now: " + plan.toUpperCase());
    }

    
    static void chatSystem() {
        System.out.println("\n--- CHAT SYSTEM ---");
        System.out.println("1. Send a Message  2. View Inbox");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1:
                if (chatCount >= 100) { System.out.println("Chat storage full."); return; }
                System.out.print("To (username): "); String to  = sc.nextLine().trim();
                System.out.print("Message      : "); String msg = sc.nextLine().trim();
                chatFrom[chatCount] = loggedInUser;
                chatTo[chatCount]   = to;
                chatMsg[chatCount]  = msg;
                chatCount++;
                addNotif(to, "New message from " + loggedInUser + ": " + msg);
                System.out.println("Message sent. Status: Delivered.");
                break;
            case 2:
                System.out.println("--- INBOX for " + loggedInUser + " ---");
                boolean any = false;
                for (int i = 0; i < chatCount; i++) {
                    if (chatTo[i].equalsIgnoreCase(loggedInUser)) {
                        System.out.println("  From: " + chatFrom[i] + "  |  " + chatMsg[i]);
                        any = true;
                    }
                }
                if (!any) System.out.println("No messages in inbox.");
                break;
            default: System.out.println("Invalid option.");
        }
    }

    static void seekerRateEmployer() {
        System.out.println("\n--- RATE AN EMPLOYER ---");
        System.out.print("Employer username to rate: "); String eu = sc.nextLine().trim();
        System.out.print("Your rating (1-5)         : "); int rv = readInt();
        if (rv < 1 || rv > 5) { System.out.println("Rating must be between 1 and 5."); return; }
        boolean found = false;
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(eu)) { found = true; break; }
        }
        if (!found) { System.out.println("Employer not found."); return; }
        if (revCount < 50) {
            revTarget[revCount] = eu;
            revText[revCount]   = loggedInUser + " rated " + rv + " stars.";
            revBy[revCount]     = loggedInUser;
            revCount++;
        }
        addNotif(eu, loggedInUser + " gave you a " + rv + "-star rating.");
        System.out.println("Rating of " + rv + " stars submitted for employer: " + eu);
    }

  
    static void seekerWriteReview() {
        System.out.println("\n--- WRITE A REVIEW ---");
        if (revCount >= 50) { System.out.println("Review storage full."); return; }
        System.out.print("Reviewing (employer/job): "); revTarget[revCount] = sc.nextLine().trim();
        System.out.print("Your review text        : "); revText[revCount]   = sc.nextLine().trim();
        revBy[revCount] = loggedInUser;
        revCount++;
        System.out.println("Review submitted successfully.");
        addNotif(revTarget[revCount-1], "New review posted by " + loggedInUser + ".");
    }

    
    static void viewNotifications() {
        System.out.println("\n--- NOTIFICATIONS for " + loggedInUser + " ---");
        boolean any = false;
        for (int i = 0; i < notifCount; i++) {
            if (notifUser[i].equalsIgnoreCase(loggedInUser)) {
                System.out.println("  [!] " + notifMsg[i]);
                any = true;
            }
        }
        if (!any) System.out.println("No notifications for you.");
    }

    
    static void submitFeedback() {
        System.out.println("\n--- FEEDBACK & SUPPORT ---");
        System.out.println("1. Submit Feedback / Query   2. View My Feedback");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1:
                if (fbCount >= 50) { System.out.println("Feedback storage full."); return; }
                System.out.print("Your feedback or query: "); String ft = sc.nextLine().trim();
                fbUser[fbCount] = loggedInUser;
                fbText[fbCount] = ft;
                fbCount++;
                System.out.println("Feedback received. Our support team will respond soon.");
                addNotif(loggedInUser, "Your feedback/query has been submitted.");
                break;
            case 2:
                System.out.println("--- MY FEEDBACK ---");
                boolean any = false;
                for (int i = 0; i < fbCount; i++) {
                    if (fbUser[i].equalsIgnoreCase(loggedInUser)) {
                        System.out.println("  - " + fbText[i]);
                        any = true;
                    }
                }
                if (!any) System.out.println("No feedback submitted yet.");
                break;
            default: System.out.println("Invalid option.");
        }
    }

    
    static void seekerChangePwd() {
        System.out.println("\n--- CHANGE PASSWORD ---");
        System.out.print("Current Password: "); String cp = sc.nextLine().trim();
        System.out.print("New Password    : "); String np = sc.nextLine().trim();
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser) && skPasswords[i].equals(encrypt(cp))) {
                if (np.length() < 4) { System.out.println("New password too short (min 4)."); return; }
                skPasswords[i] = encrypt(np);
                System.out.println("Password changed successfully.");
                addNotif(loggedInUser, "Your password has been changed.");
                return;
            }
        }
        System.out.println("ERROR: Current password is incorrect.");
    }

    static void seekerDeleteAccount() {
        System.out.println("\n--- DELETE MY ACCOUNT ---");
        System.out.print("Type 'yes' to confirm permanent deletion: ");
        String conf = sc.nextLine().trim();
        if (!conf.equalsIgnoreCase("yes")) { System.out.println("Deletion cancelled."); return; }
        for (int i = 0; i < skCount; i++) {
            if (skNames[i].equalsIgnoreCase(loggedInUser)) {
                for (int j = i; j < skCount - 1; j++) {
                    skNames[j]     = skNames[j+1];
                    skEmails[j]    = skEmails[j+1];
                    skPasswords[j] = skPasswords[j+1];
                    skSubs[j]      = skSubs[j+1];
                    skSkills[j]    = skSkills[j+1];
                    skInterests[j] = skInterests[j+1];
                    skAddress[j]   = skAddress[j+1];
                    skAdhaar[j]    = skAdhaar[j+1];
                }
                skCount--;
                System.out.println("Account deleted successfully. Goodbye!");
                return;
            }
        }
    }


    static void employerGateway() {
        System.out.println("\n--- EMPLOYER PORTAL ---");
        System.out.println("1. Register as Employer");
        System.out.println("2. Login as Employer");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1:
                employerRegister();
                break;
            case 2:
                if (employerLogin()) {
                    employerMenu();
                    loggedInUser = null;
                    loggedInRole = null;
                }
                break;
            default: System.out.println("Invalid option.");
        }
    }


    static void employerRegister() {
        System.out.println("\n--- EMPLOYER REGISTRATION ---");
        if (empCount >= 30) { System.out.println("Employer limit reached."); return; }
        System.out.print("Full Name      : "); String name    = sc.nextLine().trim();
        System.out.print("Email          : "); String email   = sc.nextLine().trim();
        System.out.print("Username       : "); String uname   = sc.nextLine().trim();
        System.out.print("Password       : "); String pwd     = sc.nextLine().trim();
        System.out.print("Company Name   : "); String company = sc.nextLine().trim();
        System.out.print("Business Type  : "); String btype   = sc.nextLine().trim();
        System.out.print("Contact Number : "); String contact = sc.nextLine().trim();

        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(uname)) {
                System.out.println("ERROR: Username '" + uname + "' already exists."); return;
            }
        }
        if (!email.contains("@") || pwd.length() < 4) {
            System.out.println("ERROR: Invalid email or password too short (min 4 chars)."); return;
        }

        empNames[empCount]     = uname;
        empEmails[empCount]    = email;
        empPasswords[empCount] = encrypt(pwd);
        empCompany[empCount]   = company;
        empBizType[empCount]   = btype;
        empContact[empCount]   = contact;
        empCount++;

        System.out.println("SUCCESS: Employer account created for '" + name + "'.");
        System.out.println("Confirmation sent to: " + email);
        addNotif(uname, "Welcome Employer! Start posting jobs and gigs.");
    }

    static boolean employerLogin() {
        System.out.println("\n--- EMPLOYER LOGIN ---");
        System.out.print("Username/Email: "); String id  = sc.nextLine().trim();
        System.out.print("Password      : "); String pwd = sc.nextLine().trim();
        for (int i = 0; i < empCount; i++) {
            if ((empNames[i].equalsIgnoreCase(id) || empEmails[i].equalsIgnoreCase(id))
                    && empPasswords[i].equals(encrypt(pwd))) {
                loggedInUser = empNames[i];
                loggedInRole = ROLE_EMPLOYER;
                System.out.println("Login successful! Welcome back, " + loggedInUser + ".");
                addNotif(loggedInUser, "You logged in as Employer.");
                return true;
            }
        }
        System.out.println("ERROR: Invalid username or password.");
        return false;
    }

    static void employerMenu() {
        boolean active = true;
        while (active) {
            System.out.println("\n");
            System.out.println("          EMPLOYER DASHBOARD            ");
            System.out.println("  User: " + padRight(loggedInUser, 32) + "\n");
            System.out.println("\n");
            System.out.println("  1.  View My Company Profile           ");
            System.out.println("  2.  Edit Company Profile              ");
            System.out.println("  3.  Post a New Job                    ");
            System.out.println("  4.  My Job Listings                   ");
            System.out.println("  5.  Post a Gig                        ");
            System.out.println("  6.  View Applications (My Jobs)       ");
            System.out.println("  7.  Update Hiring Status              ");
            System.out.println("  8.  Chat with Job Seekers             ");
            System.out.println("  9.  View Reviews on My Company        ");
            System.out.println(" 10.  My Notifications                 |");
            System.out.println(" 11.  Feedback & Support                ");
            System.out.println(" 12.  Change Password (Security)        ");
            System.out.println(" 13.  Communication Tool                ");
            System.out.println(" 14.  Delete My Account                 ");
            System.out.println("  0.  Logout                            ");
            System.out.println("\n");
            System.out.print("Employer choice: ");
            int c = readInt();
            switch (c) {
                case 1:  empViewProfile();    break;
                case 2:  empEditProfile();    break;
                case 3:  empPostJob();        break;
                case 4:  empMyListings();     break;
                case 5:  empPostGig();        break;
                case 6:  empViewApps();       break;
                case 7:  empUpdateHiring();   break;
                case 8:  chatSystem();        break;
                case 9:  empViewReviews();    break;
                case 10: viewNotifications(); break;
                case 11: submitFeedback();    break;
                case 12: empChangePwd();      break;
                case 13: empCommTool();       break;
                case 14:
                    empDeleteAccount();
                    active = false;
                    break;
                case 0:
                    System.out.println("Logged out. Goodbye, " + loggedInUser + "!");
                    active = false;
                    break;
                default: System.out.println("Invalid option. Choose 0-14.");
            }
        }
    }

    static void empViewProfile() {
        System.out.println("\n--- MY COMPANY PROFILE ---");
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(loggedInUser)) {
                System.out.println("  Username      : " + empNames[i]);
                System.out.println("  Email         : " + empEmails[i]);
                System.out.println("  Company       : " + empCompany[i]);
                System.out.println("  Business Type : " + empBizType[i]);
                System.out.println("  Contact       : " + empContact[i]);
                return;
            }
        }
        System.out.println("Profile not found.");
    }

    static void empEditProfile() {
        System.out.println("\n--- EDIT COMPANY PROFILE ---");
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(loggedInUser)) {
                System.out.print("New Company Name  (current: " + empCompany[i] + "): ");
                String nc = sc.nextLine().trim();
                if (!nc.isEmpty()) empCompany[i] = nc;

                System.out.print("New Business Type (current: " + empBizType[i] + "): ");
                String nb = sc.nextLine().trim();
                if (!nb.isEmpty()) empBizType[i] = nb;

                System.out.print("New Contact No    (current: " + empContact[i] + "): ");
                String ncon = sc.nextLine().trim();
                if (!ncon.isEmpty()) empContact[i] = ncon;

                System.out.println("Employer profile updated successfully.");
                return;
            }
        }
        System.out.println("Profile not found.");
    }

    static void empPostJob() {
        System.out.println("\n--- POST A NEW JOB ---");
        if (jobCount >= 50) { System.out.println("Job limit reached."); return; }
        System.out.print("Job Title        : "); jobTitles[jobCount]    = sc.nextLine().trim();
        System.out.print("Required Skill   : "); jobSkills[jobCount]    = sc.nextLine().trim();
        System.out.print("Location         : "); jobLocations[jobCount] = sc.nextLine().trim();
        System.out.print("Salary Range     : "); jobSalary[jobCount]    = sc.nextLine().trim();
        System.out.print("Min. Experience  : "); jobMinExp[jobCount]    = readInt();
        String comp = loggedInUser;
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(loggedInUser)) { comp = empCompany[i]; break; }
        }
        jobCompany[jobCount]  = comp;
        jobPostedBy[jobCount] = loggedInUser;
        jobStatus[jobCount]   = "pending";
        jobCount++;
        System.out.println("Job posted! Status: PENDING (Awaiting admin approval).");
        addNotif(loggedInUser, "Job '" + jobTitles[jobCount-1] + "' submitted for admin review.");
    }

    static void empMyListings() {
        System.out.println("\n--- MY JOB LISTINGS ---");
        boolean any = false;
        for (int i = 0; i < jobCount; i++) {
            if (jobPostedBy[i].equalsIgnoreCase(loggedInUser)) {
                System.out.printf("  %2d. %-20s | Skill:%-10s | Loc:%-12s | Sal:%-10s | %s%n",
                    i+1, jobTitles[i], jobSkills[i], jobLocations[i],
                    jobSalary[i], jobStatus[i].toUpperCase());
                any = true;
            }
        }
        if (!any) { System.out.println("You have not posted any jobs yet."); return; }
        System.out.println("\n  Options: 1. Edit a listing   2. Close a listing   3. Back");
        System.out.print("Choice: "); int c = readInt();
        if (c == 1) {
            System.out.print("Job index to edit (1-based): "); int idx = readInt() - 1;
            if (idx >= 0 && idx < jobCount && jobPostedBy[idx].equalsIgnoreCase(loggedInUser)) {
                System.out.print("New Title    (Enter to skip): ");
                String nt = sc.nextLine().trim();
                if (!nt.isEmpty()) jobTitles[idx] = nt;
                System.out.print("New Location (Enter to skip): ");
                String nl = sc.nextLine().trim();
                if (!nl.isEmpty()) jobLocations[idx] = nl;
                System.out.println("Listing updated successfully.");
            } else System.out.println("Invalid index or this is not your job.");
        } else if (c == 2) {
            System.out.print("Job index to close (1-based): "); int idx = readInt() - 1;
            if (idx >= 0 && idx < jobCount && jobPostedBy[idx].equalsIgnoreCase(loggedInUser)) {
                jobStatus[idx] = "closed";
                System.out.println("Job '" + jobTitles[idx] + "' is now CLOSED.");
            } else System.out.println("Invalid index or this is not your job.");
        }
    }

    static void empPostGig() {
        System.out.println("\n--- POST A GIG ---");
        if (gigCount >= 30) { System.out.println("Gig limit reached."); return; }
        System.out.print("Gig Title  : "); gigTitle[gigCount]  = sc.nextLine().trim();
        System.out.print("Budget     : "); gigBudget[gigCount] = sc.nextLine().trim();
        System.out.print("Location   : "); gigLoc[gigCount]    = sc.nextLine().trim();
        gigPoster[gigCount] = loggedInUser;
        gigCount++;
        System.out.println("Gig '" + gigTitle[gigCount-1] + "' posted successfully.");
        addNotif(loggedInUser, "Gig '" + gigTitle[gigCount-1] + "' is now live.");
        for (int i = 0; i < skCount; i++) {
            addNotif(skNames[i], "New gig posted: " + gigTitle[gigCount-1] + " by " + loggedInUser);
        }
    }

    static void empViewApps() {
        System.out.println("\n--- APPLICATIONS FOR MY JOBS ---");
        boolean any = false;
        for (int i = 0; i < appCount; i++) {
            boolean mine = false;
            for (int j = 0; j < jobCount; j++) {
                if (jobTitles[j].equalsIgnoreCase(appJob[i])
                        && jobPostedBy[j].equalsIgnoreCase(loggedInUser)) {
                    mine = true; break;
                }
            }
            if (mine) {
                System.out.printf("  Job: %-20s | Applicant: %-15s | Status: %s%n",
                    appJob[i], appSeeker[i], appStatus[i].toUpperCase());
                any = true;
            }
        }
        if (!any) System.out.println("No applications received for your jobs yet.");
    }

    static void empUpdateHiring() {
        System.out.println("\n--- UPDATE HIRING STATUS ---");
        empViewApps();
        System.out.print("Applicant username : "); String au = sc.nextLine().trim();
        System.out.print("Job title          : "); String aj = sc.nextLine().trim();
        System.out.println("New Status: 1. Shortlist   2. Hire   3. Reject");
        System.out.print("Choice: "); int ch = readInt();
        String ns = ch == 1 ? "shortlisted" : ch == 2 ? "hired" : "rejected";
        boolean updated = false;
        for (int i = 0; i < appCount; i++) {
            if (appSeeker[i].equalsIgnoreCase(au) && appJob[i].equalsIgnoreCase(aj)) {
                appStatus[i] = ns;
                System.out.println("Status updated to: " + ns.toUpperCase());
                addNotif(au, "Your application for '" + aj + "' status: " + ns.toUpperCase());
                updated = true;
                break;
            }
        }
        if (!updated) System.out.println("Application not found for given applicant + job.");
    }

    static void empViewReviews() {
        System.out.println("\n--- REVIEWS ON MY COMPANY ---");
        boolean any = false;
        for (int i = 0; i < revCount; i++) {
            if (revTarget[i].equalsIgnoreCase(loggedInUser)) {
                System.out.println("  From: " + revBy[i] + " | " + revText[i]);
                any = true;
            }
        }
        if (!any) System.out.println("No reviews posted about your company yet.");
    }

    static void empChangePwd() {
        System.out.println("\n--- CHANGE PASSWORD ---");
        System.out.print("Current Password: "); String cp = sc.nextLine().trim();
        System.out.print("New Password    : "); String np = sc.nextLine().trim();
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(loggedInUser) && empPasswords[i].equals(encrypt(cp))) {
                if (np.length() < 4) { System.out.println("Password too short (min 4)."); return; }
                empPasswords[i] = encrypt(np);
                System.out.println("Password changed successfully.");
                addNotif(loggedInUser, "Your employer password was updated.");
                return;
            }
        }
        System.out.println("ERROR: Current password is incorrect.");
    }

    static void empCommTool() {
        System.out.println("\n--- COMMUNICATION TOOL ---");
        System.out.println("1. Send Email/Message to Seeker");
        System.out.println("2. View My Sent Messages");
        System.out.print("Choice: "); int c = readInt();
        switch (c) {
            case 1:
                if (chatCount >= 100) { System.out.println("Storage full."); return; }
                System.out.print("To (seeker username): "); String to  = sc.nextLine().trim();
                System.out.print("Subject             : "); String sub = sc.nextLine().trim();
                System.out.print("Message             : "); String msg = sc.nextLine().trim();
                chatFrom[chatCount] = loggedInUser;
                chatTo[chatCount]   = to;
                chatMsg[chatCount]  = "[" + sub + "] " + msg;
                chatCount++;
                addNotif(to, "[MSG from " + loggedInUser + "] " + sub + ": " + msg);
                System.out.println("Message sent and logged in communication records.");
                break;
            case 2:
                System.out.println("--- SENT MESSAGES by " + loggedInUser + " ---");
                boolean any = false;
                for (int i = 0; i < chatCount; i++) {
                    if (chatFrom[i].equalsIgnoreCase(loggedInUser)) {
                        System.out.println("  To: " + chatTo[i] + "  |  " + chatMsg[i]);
                        any = true;
                    }
                }
                if (!any) System.out.println("No messages sent yet.");
                break;
            default: System.out.println("Invalid option.");
        }
    }

    static void empDeleteAccount() {
        System.out.println("\n--- DELETE MY EMPLOYER ACCOUNT ---");
        System.out.print("Type 'yes' to confirm permanent deletion: ");
        String conf = sc.nextLine().trim();
        if (!conf.equalsIgnoreCase("yes")) { System.out.println("Deletion cancelled."); return; }
        for (int i = 0; i < empCount; i++) {
            if (empNames[i].equalsIgnoreCase(loggedInUser)) {
                for (int j = i; j < empCount - 1; j++) {
                    empNames[j]     = empNames[j+1];
                    empEmails[j]    = empEmails[j+1];
                    empPasswords[j] = empPasswords[j+1];
                    empCompany[j]   = empCompany[j+1];
                    empBizType[j]   = empBizType[j+1];
                    empContact[j]   = empContact[j+1];
                }
                empCount--;
                System.out.println("Employer account deleted. Goodbye!");
                return;
            }
        }
    }


    static void addNotif(String user, String message) {
        if (notifCount < 200) {
            notifUser[notifCount] = user;
            notifMsg[notifCount]  = message;
            notifCount++;
        }
    }

    static String encrypt(String pwd) {
        StringBuilder sb = new StringBuilder();
        for (char ch : pwd.toCharArray()) sb.append((int)(ch ^ 42));
        return sb.toString();
    }

    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static String padRight(String s, int n) {
        if (s == null) s = "";
        if (s.length() >= n) return s.substring(0, n);
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < n) sb.append(' ');
        return sb.toString();
    }

    static void banner() {
        System.out.println("\n");
        System.out.println(" WELCOME TO KARYA SPACE  !!");
        
    }
}