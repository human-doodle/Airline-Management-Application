# -*- coding: utf-8 -*-
"""
Created on Thu Aug 13 18:57:04 2020

@author: Shivani
"""

class Customer:
    __id=0 #static variable
    def __init__(self, name, age):
        self.__name=name
        self.__age = age
        Customer.__id=Customer.__id+1
    def display(self):
        print("\n")
        print("Customer id : "+ str(self.__id))
        print("Name : "+ self.__name)
        print("Age: "+ str(self.__age))
        print("\n")
    def retcusinfo(self):
        return self.__id, self.__name, self.__age
        
    