# -*- coding: utf-8 -*-
"""
Created on Thu Aug 13 19:58:44 2020

@author: Shivani
"""

class Booking:
    def __init__(self,userinfo, flightinfo):
        self.__id=userinfo[0]
        self.__name=userinfo[1]
        self.__age=userinfo[2]
        self.__num= flightinfo[0]
        self.__to=flightinfo[1]
        self.__from=flightinfo[2]
        self.__date=flightinfo[3]
        self.__quota=flightinfo[4]
    
    def display(self):
        print("\n")
        print("Customer id: ",self.__id)
        print("Customer name: ",self.__name)
        print("Customer name: ",self.__age)
        print("Flight num: ",self.__num)
        print("Source: ",self.__from)
        print("Destination: ",self.__to)
        print("Date: ",self.__date)
        print("Quota: ",self.__quota)
        print("\n")
    
    def retbook(self):
        return self.__id, self.__name,self.__age, self.__num, self.__to,self.__from, self.__date, self.__quota
        