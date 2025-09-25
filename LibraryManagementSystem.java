 
 import java.time.LocalDate;
import java.util.*;

 class Book
 {
    String bookName;
    String bookId;
    String bookAuthor;
   private int copiesAvailable;

    public Book(String bookName,String bookId,String bookAuthor,int copiesAvailable)
    {
          this.bookName=bookName;
          this.bookId=bookId;
          this.bookAuthor=bookAuthor;
          this.copiesAvailable=copiesAvailable;
    }
    public void setCopiesAvailable(int copiesAvailable)
    {
      this.copiesAvailable=copiesAvailable;
    }
    public int getCopiesAvailable()
    {
      return copiesAvailable;
    }

 }
 

 class User
 {
   private String userName;
   private int userId;

    public User(String userName,int userId)
    {
       this.userName=userName;
       this.userId=userId;
    }
    public void setUserName(String userName)
    {
       this.userName=userName;
    }
    public String getUserName()
    {
      return userName;
    }
    public void setUserId(int userId)
    {
       this.userId=userId;
    }
    public int getUserId()
    {
      return userId;
    }
 }

 class Library
 {
    String libraryName;
    private String shelfLocation;
    String category;
    String language;

    public Library(String libraryName,String shelfLocation,String category,String language)
    {
         this.libraryName=libraryName;
         this.shelfLocation=shelfLocation;
         this.category=category;
         this.language=language;
    }
    public void setshelfLocation(String shelfLocation)
    {
          this.shelfLocation=shelfLocation;
    }
    public String getshelfLocation()
    {
      return shelfLocation;
    }

 }

 class BookIssueRecord
 {
   Book book;
   User user;
   Library library;
   LocalDate issueDate;
   LocalDate returnDate;
   public BookIssueRecord(User user, Book book, Library library, LocalDate issueDate, LocalDate returnDate)
    {
        this.user = user;
        this.book = book;
        this.library = library;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
 }

 class MiniLibrarySystem
 {
    Stack<Book> bookDetails = new Stack<>();
    ArrayList<User> userDetails = new ArrayList<>();
    ArrayList<Library> libraryDetails = new ArrayList<>();
    ArrayList<BookIssueRecord> issueRecords = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

   public void librarySystem()
   { 
     boolean found = true;

     while (found) 
     {
         System.out.println("\nSELECT ANY OF THE ONE BELOW");
         System.out.println("0.EXIT");
         System.out.println("1.LIBRARY BOOK ISSUE AND RETURN FEATURES");
         int select = sc.nextInt();
         sc.nextLine();
         if(select==0)
         {
          System.out.println("YOU HAVE EXITED");
          break;
         }
         else
         {
           switch (select)
           {
            case 1:
                boolean subMenuActive = true;
                while(subMenuActive)
                {
                  System.out.println("\nSELECT ANY ONE YOU WANT");
                  System.out.println("0.EXIT");
                  System.out.println("1.ADD THE BOOK DETAILS INTO SHELF");
                  System.err.println("2.ADD USER DETAILS");
                  System.err.println("3.ADD LIBRARY DETAILS");
                  System.out.println("4.BOOK ISSUE & RETURN DETAILS");
                  int choose = sc.nextInt();
                  sc.nextLine();

                  if(choose==0)
                  {
                    System.out.println("YOU HAVE EXITED");
                    break;
                  }
                  else
                  {
                   switch(choose)
                   {
                    case 1:
                         System.out.print("ENTER THE BOOK NAME:");
                         String bookName = sc.nextLine();
                         System.out.print("ENTER THE BOOK ID:");
                         String bookId = sc.nextLine();
                         System.out.print("ENTER THE BOOK AUTHOR:");
                         String bookAuthor = sc.nextLine();
                         System.out.print("ENTER THE HOW MANY COPIES AVAILABLE:");
                         int copiesAvailable = sc.nextInt();
                         sc.nextLine();
                         Book book = new Book(bookName, bookId, bookAuthor,copiesAvailable);
                         bookDetails.push(book);
                      break;
                    case 2:
                         System.out.print("ENTER THE USER NAME:");
                         String userName = sc.nextLine();
                         System.out.print("ENTER THE USER ID:");
                         int userId = sc.nextInt();
                         sc.nextLine();
                         User user = new User(userName, userId);
                         userDetails.add(user);
                      break;
                    case 3:
                         System.out.print("ENTER THE LIBRARY NAME:");
                         String libraryName = sc.nextLine();
                         System.out.print("ENTER SHELF LOCATION TO FIND THE BOOK:");
                         String shelfLocation = sc.nextLine();
                         System.out.print("ENTER THE BOOK GENRE YOU WANT:");
                         String catogory = sc.nextLine();
                         System.out.print("ENTER THE THE LANGUAGE:");
                         String language = sc.nextLine();
                         Library library = new Library(libraryName, shelfLocation, catogory, language);
                         libraryDetails.add(library);
                      break;
                    case 4:
                         System.out.println("\nSELECT ANY ONE YOU WANT");
                         System.out.println("1. Issue Book");
                         System.out.println("2. Return Book");
                         System.out.println("3. Display Issue Records");
                         int issueOption = sc.nextInt();
                         sc.nextLine();

                         if(issueOption==1)
                         {
                             if (bookDetails.isEmpty())
                             {
                               System.out.println("No books available to issue.");
                               break;
                             }
                             if(userDetails.isEmpty())
                             {
                               System.out.println("No users present. Add users first.");
                               break;
                             }
                             if(libraryDetails.isEmpty())
                             {
                               System.out.println("No library details present. Add library first.");
                               break;
                             }
                             System.out.print("Enter User ID who wants to issue book:");
                             int uid = sc.nextInt();
                             sc.nextLine();
                             User issuingUser = null;
                             for(User u : userDetails)
                             {
                               if(uid==u.getUserId())
                               {
                                 issuingUser = u;
                                 break;
                               }
                             }
                             if(issuingUser==null)
                             {
                              System.out.println("User not found.");
                               break;
                             }
                             System.out.print("Enter Book ID to issue:");
                             String bId = sc.nextLine();
                             Book issuingBook = null;
                             for(Book b : bookDetails)
                             {
                               if(b.bookId.equals(bId))
                               {
                                   issuingBook = b;
                                   break;
                               }
                             }
                             if(issuingBook == null) 
                             {
                               System.out.println("Book not found.");
                               break;
                             }
                             if(issuingBook.getCopiesAvailable() <= 0) 
                             {
                               System.out.println("No copies available of this book.");
                               break;
                             }
                             System.out.print("Enter Library Name:");
                             String libName = sc.nextLine();
                             Library usedLibrary = null;
                            for(Library lib : libraryDetails) 
                            {
                                if(lib.libraryName.equalsIgnoreCase(libName))
                                {
                                   usedLibrary = lib;
                                   break;
                                }
                            }
                            if(usedLibrary == null)
                            {
                               System.out.println("Library not found.");
                               break;
                            }

                            System.out.print("Enter Issue Date (yyyy-mm-dd): ");
                            String issueDateStr = sc.nextLine();
                            LocalDate issueDate = LocalDate.parse(issueDateStr);

                            System.out.print("Enter Return Date (yyyy-mm-dd): ");
                            String returnDateStr = sc.nextLine();
                            LocalDate returnDate = LocalDate.parse(returnDateStr);


                            issuingBook.setCopiesAvailable(issuingBook.getCopiesAvailable() - 1);

                            BookIssueRecord record = new BookIssueRecord(issuingUser, issuingBook, usedLibrary, issueDate, returnDate);
                            issueRecords.add(record);
                            System.out.println("Book issued to " + issuingUser.getUserName() + " successfully.");
                         }
                         else if(issueOption == 2)
                         {
                           System.out.print("Enter User ID who is returning book:");
                           int ruId = sc.nextInt();
                           sc.nextLine();
                           System.out.print("Enter Book ID:");
                           String rbId = sc.nextLine();

                           boolean foundRecord = false;

                           Iterator<BookIssueRecord> iterator = issueRecords.iterator();
                           while(iterator.hasNext())
                           {
                            BookIssueRecord rec = iterator.next();
                            if(rec.user.getUserId() == ruId && rec.book.bookId.equals(rbId))
                            {
                              foundRecord = true;
                              rec.book.setCopiesAvailable(rec.book.getCopiesAvailable() + 1);
                              iterator.remove();
                              System.out.println("Book returned successfully.");
                              foundRecord=true;
                              break;
                            }
                           }
                           if(!foundRecord)
                          {
                            System.out.println("Issue record not found for user and book.");
                          }
                         }
                         else if(issueOption == 3)
                         {
                          System.out.println("Displaying all book issue records:");
                           if(issueRecords.isEmpty())
                           {
                            System.out.println("No issue records found.");
                           }
                           else
                           {
                            for(BookIssueRecord rec : issueRecords)
                            {
                                System.out.println("-----------------------------------");
                                System.out.println("User: " + rec.user.getUserName() + " (ID: " + rec.user.getUserId() + ")");
                                System.out.println("Book: " + rec.book.bookName + " (ID: " + rec.book.bookId + ")");
                                System.out.println("Library: " + rec.library.libraryName + ", Genre: " + rec.library.category);
                                System.out.println("Issue Date: " + rec.issueDate);
                                System.out.println("Return Date: " + rec.returnDate);
                            }
                           }
                          }
                          else
                          {
                            System.out.println("Invalid option.");
                          }


                      break;                 
                    default:
                         System.out.println("INVALID OPTINO YOU ENTERED");
                       break;
                   }
                  }
                }
                  break;
           
            default:
                  System.out.println("INVALID OPTINO YOU ENTERED");
              break;
           }
         }
     }
     sc.close();
   }
 }
 public class LibraryManagementSystem
 {
  public static void main(String[] args)
  {
    MiniLibrarySystem mls = new MiniLibrarySystem();
    mls.librarySystem();
  }
 }

 

