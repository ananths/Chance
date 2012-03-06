import static org.junit.Assert.*;

import org.junit.Test;

public class ChanceTest {

	@Test
	public void shouldCreateChanceWithFractionValueHalf(){
		Chance chance = new Chance(0.5);
		assertNotNull(chance);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateChanceWithValueLessThan0(){
		new Chance(-.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateChanceWithValueGreaterThan1(){
		new Chance(2.0);
	}
	
	@Test
	public void shouldEquate2ChancesWithSameState(){
		Chance firstChance = new Chance(0.75);
		Chance secondChance = new Chance(0.75);
		
		assertTrue(firstChance.equals(firstChance));
		assertFalse(firstChance.equals(null));
		assertFalse(firstChance.equals("Chance"));
		assertTrue(firstChance.equals(secondChance));
		
		assertFalse(firstChance.equals(new Chance(0.28)));
	}
	
	
	
	@Test
	public void shouldReturnNotOfAChance(){
		Chance chance = new Chance(0.75);
		Chance notChance = new Chance(0.25);
		
		assertEquals(notChance, chance.not());
	}
	
	@Test
	public void shouldAndChances(){
		Chance firstChance = new Chance(0.75);
		Chance secondChance = new Chance(0.25);
		Chance andedChance = new Chance(0.1875);
		
		assertEquals(andedChance, firstChance.and(secondChance));
	}
	
	@Test
	public void shouldOrChances(){
		Chance firstChance = new Chance(0.75);
		Chance secondChance = new Chance(0.25);
		Chance oredChance = new Chance(0.8125);
		
		assertEquals(oredChance, firstChance.or(secondChance));
	}
}
