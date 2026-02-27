void main(){

    try (Scanner input = new Scanner (System.in)) {
    IO.print("Enter your name : ");
    String name = input.nextLine();

    IO.print("Enter your birth of year : ");
    int year = input.nextInt();
    IO.print("Are you Thai people?  (Y/N):");
    char answer = input.next().charAt(0);
    //IO.print(""+answer);
    boolean isThai;
    if(answer == 'Y'){
        isThai = true;
    } else {
        answer = 'N';
        isThai = false;
    }
    IO.print("Are you male?  (Y/N):");
    char gender = input.next().charAt(0);
    boolean isMale;
    if(gender == 'Y'){
        isMale = true;
    } else {
        isMale = false;
    }

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
    String formattedDateTime = now.format(formatter);
    int currentYear = Integer.parseInt(formattedDateTime);
    int age = currentYear - year;

    
    IO.print("Your name is :"+name);
    IO.print("Your age is :"+age);
    boolean isEligibleToVote = (age >= 18) && isThai;
    if (isEligibleToVote){
        IO.print(" You have the right to vote and serve your country");
    }else if (isEligibleToVote) {
        IO.print(" You do not have the right to vote");
    }else if (isMale) {
        IO.print(" You do not have the right to vote");
    }else {
        IO.print(" You do not have the right to vote and serve your country");
    }

    input.close();


    } catch(InputMismatchException e){
        IO.print("Invalid input");
    
    }
}
