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
        print("Flight number : "+ self.__num)
        print("Flight source : "+ self.__from)
        print("Flight destination : "+ self.__to)
        print("Flight date : "+ str(self.__date))
        print("Flight quota : "+ self.__quota)
        