package ua.nure.kn.pyvovarov.agent;
import jade.core.Agent;

public class SearchAgent extends Agent {

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		super.setup();
		System.out.println(getAID().getName() + " started");
	}

	@Override
	protected void takeDown() {
		// TODO Auto-generated method stub
		System.out.println(getAID().getName() + " terminated");
		super.takeDown();
	}

}