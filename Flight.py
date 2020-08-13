# -*- coding: utf-8 -*-
"""
Created on Thu Aug 13 18:56:26 2020

@author: Shivani
"""

class Flight:
    def __init__(self, num, f, t, d, q):
        self.__num= num
        self.__to=t
        self.__from=f
        self.__date=d
        self.__quota=q
   
    def display(self):
        print("\n")
        print("Flight num: ",self.__num)
        print("Source: ",self.__from)
        print("Destination: ",self.__to)
        print("Date: ",self.__date)
        print("Quota: ",self.__quota)
        print("\n")
        
    def retinfo(self):
        return self.__num,self.__from, self.__to,self.__date, self.__quota