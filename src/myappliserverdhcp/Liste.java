/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;



import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;


public class Liste {

   public static void main(String[] args) {
      
      TreeMap<Integer, String> tm = new TreeMap<>();
      tm.put(1, "> 192.168.1.2");
      tm.put(2, "> 192.168.1.3");
      tm.put(3, "> 192.168.1.4");
      tm.put(4, "> 192.168.1.5");
      tm.put(5, "> 192.168.1.6");
      //Cette instruction affiche le contenu trié de la collection
      System.out.println(tm);
      
      //Exemple de méthodes de l'interface SortedMap<K,V>
      //-----------------------------------------------------
      //Retourne les deux premiers éléments de la collection
      System.out.println(tm.headMap(22));
      //Retourne les trois derniers éléments de la collection
      System.out.println(tm.tailMap(22));
      //retourne la liste des valeurs
      System.out.println(tm.values());
      
      //Exemple de méthodes de l'interface NavigableMap<K,V>
      //-----------------------------------------------------
      //Retourne le couple correspondant à la clé 40
      System.out.println(tm.ceilingEntry(32));
      //Retourne la première entrée de la collection
      System.out.println(tm.firstEntry());
      //Retourne la clé 50
      System.out.println(tm.lowerKey(61));
      //Retourne les couples correspondant aux clés 30 et 40
      System.out.println(tm.subMap(20, false, 40, true));
      
      System.out.println("Nous allons parcourir cette collection");
      Set<Entry<Integer, String>> set = tm.entrySet();
      Iterator<Map.Entry<Integer, String>> it = set.iterator();

      //Nous créons une nouvelle collection avec un comparateur 
      //pour trier dans le sens inverse
      TreeMap<Integer, String> tm2 = new TreeMap<>(new Comparator<Integer>(){
         public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
         }
      });
      
      //On parcourt notre itérateur
      while(it.hasNext()){
         Map.Entry<Integer, String> entry = it.next();
         System.out.println(entry);
         //Et on insère dans notre nouvelle collection
         tm2.put(entry.getKey(), entry.getValue());
      }
      
      //La collection s'affiche bien dans le sens inverse de la précédente
      System.out.println(tm2);
      
      //une autre méthode pour parcourir une collection de ce type
      //mais cette fois, les éléments sont retirés au fur et à mesure...
      System.out.println("Dépilage de la deuxième collection :");
      Entry<Integer, String> entry = null;
      while((entry = tm2.pollFirstEntry()) != null)
         System.out.println(entry);
      
      //A ce moment du programme, il n'y a plus rien dans la seconde collection
      System.out.println(tm2);
   }
}