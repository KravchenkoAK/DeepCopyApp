package com.alexkrav.deepcopy;

import com.alexkrav.deepcopy.models.Address;
import com.alexkrav.deepcopy.models.Man;
import com.alexkrav.deepcopy.service.DeepCopyObjectService;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address address = new Address("Russia", "Samara", "Samara, Lesnaya 23, 1");
        List<String> favoriteBooks = new ArrayList<String>();
        favoriteBooks.add("Garry Potter");
        favoriteBooks.add("Crime and punishment");
        favoriteBooks.add("Green book");

        Man man = new Man("Bruice Docker", 25, favoriteBooks, null,true);
        System.out.println(address);
        Address copyAddress = (Address) DeepCopyObjectService.Copy(address);
        System.out.println(copyAddress);
        Man copyMan = (Man) DeepCopyObjectService.Copy(man);
        System.out.println(copyMan);
    }
}
