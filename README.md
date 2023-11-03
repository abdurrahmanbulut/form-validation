# form-validation

This project represents 2 exercise to learn Kotlin. Jetpack compose used

1: A recursive function written in Kotlin that will determine the number of steps it takes for a given positive number to reach 1 according to the Collatz conjecture.

2: There will be 4 input fields.

    Input field 1: Text that contains only letters, without any numbers or special characters, can be entered.
    Input field 2: A positive integer can be entered.
    Input field 3: A positive integer can be entered.
    Input field 4: Plain text.

    Button: It will trigger the validation, and whether the validation is successful or not will be reflected on the screen with a toaster or something similar.
    
    Validation:
    
    No input field can be left empty. An error message will be written under the ones left empty.
    
    Input field 1. It will be checked whether the first letter of each word in the text entered in the first input field is capitalized and the rest of the letters are lowercase.
    Input field 2. It will be checked whether the sum of the numbers from 1 to the number entered in the second input field, including the number itself, is less than the number entered in the third input field; if it is less, the validation for the second input field will be considered successful.
    Input field 3. It will be checked whether a positive integer has been entered in the third input field.
    Input field 4. Input field: It will be checked whether it is a palindrome or not. If it is a palindrome, the validation will be considered successful.
