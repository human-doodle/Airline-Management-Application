# -*- coding: utf-8 -*-
"""
Created on Wed Aug 12 21:40:36 2020

@author: Shivani
"""
import datetime
import Customer, Flight


listuser=[]
listflight=[]
listbooking=[]
actor=input("Enter user/flight : ")
   
while(True):
    print("1. Add a flight")
    print("2. List all flights")
    print("3. List a flight bookings")
    print("4. Add a user")
    print("5. Display all the users")
    print("6. Book a flight")
    print("7. Cancel a flight")
    print("8. List flights booked by the user")
    print("9. Exit")
    option=input("Enter your choice : ")
        
    if(option=='1'):
        num=input("1. Enter flight number : ")
        f = input("2. Enter source : ")
        t = input("3. Enter Destination : ")
        date_entry = input('4. Enter a date in YYYY-MM-DD format : ')
        year, month, day = map(int, date_entry.split('-'))
        d = datetime.date(year, month, day)
        q = input("5. Enter Quota : ")
                
        obj=Flight.Flight(num, f, t, d, q)
        listflight.append(obj)
        print("Added!")
            
    elif(option=='2'):
        print("\n All flight details : \n ")
        for obj in listflight:
            obj.display()
            print("\n")
        
    elif(option=='3'):
        pass
    
    elif(option=='4'):
        name= input("Enter name : ")
        age = int(input("Enter age : "))
        obj=Customer.Customer(name, age)
        listuser.append(obj)       
        print("Customer Added !! ")
        
    elif(option=='5'):
        print("\n All Customer details : \n ")
        for obj in listuser:
            obj.display()
            print("\n")
        
    elif(option=='6'):
        print("Book a flight : \n")
        name = input("Enter name : ")
        flag=True
        for obj in listuser:
            if(obj.name==name):
                flag=False
        if(flag):
            print("Customer doesn't exist, Please add the customer first")
        
    elif(option=='9'):
        break
    else:
        print("Invalid input !!")