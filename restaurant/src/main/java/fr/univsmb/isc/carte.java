package fr.univsmb.isc;

import java.util.ArrayList;
import java.util.List;

public class carte {
    public List<plats> p = new ArrayList<plats> ();

    public List<menu> m = new ArrayList<menu> ();

    public void constructioncarte() {
        
        System.out.println("menus\n");
        this.listemenu();
        
        System.out.println("plats seuls\n");
        this.listeplats();
    }
    
    public void ajoutplat(plats pl){
        this.p.add(pl);
    }
    
    public void ajoutmenu(menu me){
        this.m.add(me);
    }  
    
    public void listemenu()
    {
        for(int h = 0; h < this.m.size(); h++)
        {		System.out.println(h+ " : " +  m.get(h).identitemenu());
        }
    }
    
    public void listeplats(){
        for(int j = 0; j < this.p.size(); j++){
            System.out.println(j+": "+p.get(j).identiteplat());
        }
    }
}
