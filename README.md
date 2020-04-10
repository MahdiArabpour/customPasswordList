# customPasswordList

A program for generating custom password lists for a specific account!  
You can simply enter some keywords about the owner of an account and the program generates 
all possible unrepeated-keyword passwords into a list file.  

If you have a look at the code, you might think I could generate all of that passwords in only five nested for loops 
instead of having this bunch of for loops. yes, that makes the code way shorter. but I did this so that the passwords 
with less number of keywords will be stored first and it would be better to try passwords having less keywords first.

# installation

At first you have to install java jdk!  
How to install java jdk: https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_HowTo.html

After jdk installation clone the repository:  
`git clone https://github.com/MahdiArabpour/customPasswordList.git`

Now run the pre-compiled program:  
`java customPasswordList/out/production/passwordList/passwordList/passwordList`

# Usage

Enter as much as keywords you like, then enter `\finished`.  
Now enter the maximum possible length of generated passwords you want.  
passwords will be stored in `customPasswordList/customPasswords.list`!
