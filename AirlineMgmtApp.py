# -*- coding: utf-8 -*-
"""
Created on Wed Aug 12 21:40:36 2020

@author: Shivani
"""
import datetime
import Customer, Flight, Booking


listuser=[]
listflight=[]
listbooking=[]
   
while(True):
    print("1. Add a flight")
    print("2. List all flights")
    print("3. List a flight bookings")
    print("4. Add a Customer")
    print("5. Display all the Customer")
    print("6. Book a flight")
    print("7. Cancel a Booking")
    print("8. List flights booked by the user")
    print("9. List all bookings ")
    print("10. Exit")
    option=input("Enter your choice : ")

##########################################################  
    
    if(option=='1'):
        print("\n Add flight \n ")
        num=input("1. Enter flight number : ")
        f = input("2. Enter source : ")
        t = input("3. Enter Destination : ")
        date_entry = input('4. Enter a date in YYYY-MM-DD format : ')
        year, month, day = map(int, date_entry.split('-'))
        d = datetime.date(year, month, day)
        q = input("5. Enter Quota : ")
                
        obj=Flight.Flight(num, f, t, d, q)
        listflight.append(obj)
        print("\n Added flight! \n")
         
###########################################################
        
    elif(option=='2'):
        print("\n All flight details  \n ")
        for obj in listflight:
            obj.display()
            print("\n")
         
###########################################################
                
    elif(option=='3'):
        print("\n All flight booking  \n ")
        fno=input("Enter flight number you want to view bookings for : ")
        for obj in listbooking:
            bookinfo=obj.retbook()
            print(bookinfo[3])
            if(bookinfo[3]==fno):
                obj.display()
         
###########################################################
      
    elif(option=='4'):
        print("\n Add Customer \n ")
        name= input("Enter name : ")
        age = int(input("Enter age : "))
        obj=Customer.Customer(name, age)
        listuser.append(obj)       
        print("\nCustomer Added !!",obj.retcusinfo()[0], "is the customerID \n")
           
###########################################################
        
    elif(option=='5'):
        print("\n All Customer details  \n ")
        for obj in listuser:
            obj.display()
            print("\n")
          
###########################################################
          
    elif(option=='6'):
        
        print("\n Book a flight  \n")
        id = int(input("Enter id : "))
        flag=True
        for obj in listuser:
            custinfo=obj.retcusinfo()
            print(custinfo[0])
            if(custinfo[0]==id):
                flag=False
                break
        if(flag):
            print("Customer doesn't exist, Please add the customer first \n")
        else:
            fr = input("Enter Source : ")
            to = input("Enter Destination : ")
            for obj in listflight:
                flightinfo=obj.retinfo()
                source, destination = [flightinfo[i] for i in (1, 2)]
                if(fr==source and to==destination):
                    obj.display()
            fno=input("Enter Flight number you want to book : ")
            
            for obj in listflight:
                flightno=obj.retinfo()[0]
                if(fno==flightno):
                    break
            
            objbook=Booking.Booking(custinfo, flightinfo)
            listbooking.append(objbook)
            print("\n Booked!! \n")
            objbook.display()
           
###########################################################
    
    elif(option=='7'):
        print("\n Cancel a booking \n")
        id=int(input("Enter id: "))
        fno = input("Enter flight number you want to cancel : ")
        for obj in listbooking:
            bookinfo=obj.retbook()
            print(bookinfo[0], bookinfo[3])
            if(id==bookinfo[0] and fno==bookinfo[3]):
                listbooking.remove(obj)
                print("\n Cancelled \n")
         
###########################################################
     
    elif(option=='8'):
        print("\n Flights booked by the Customer \n")
        id=int(input("Enter id: "))
        for obj in listbooking:
            bookinfo=obj.retbook()
            if(id== bookinfo[0]):
                obj.display()
                
##########################################################
                
    elif(option=='9'):
        for obj in listbooking:
            
                obj.display()
         
###########################################################
          
    elif(option=='10'):
        break
         
###########################################################
  
    else:
        print("\n Invalid input !! \n")