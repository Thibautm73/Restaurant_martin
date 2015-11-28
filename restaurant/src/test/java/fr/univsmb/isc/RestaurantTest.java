package fr.univsmb.isc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {
	
	public List<table> listable = new ArrayList<table>();
	systeme S = new systeme();
	carte c = new carte();
	
	@Test
	public void ShouldAffecteTable (){
		S.affecteTable(1,2);
		assertThat(listable).isNotNull();
		
	}
	@Test
	public void ShouldDesaffecteTable(){
		S.affecteTable(1,0);
		assertThat(listable).isNull();
		
		
	}
	
	
}
    