import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class Aderall
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;



	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "What do you want learn about Adderall?\n Price or Side Effect?";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (statement.length() == 0)
		{
			response = "Say that again, I didn't hear what you said. \n Price or Side Effects?";
		}

		else if (findKeyword(statement, "price") >= 0)
		{
			response = "The price for Adderall oral tablet 5 mg is around $680 for a supply of 100 tablets. ";

		}

		else if (findKeyword(statement, "effect") >= 0)
		{
			response = "Effects of Adderall on the Body. For people diagnosed with attention-deficit hyperactivity disorder (ADHD), Adderall helps to improve concentration and focus. \n What else do you want to learn about- Mixing with other drugs?";

		}
		else if (findKeyword(statement, "effects") >= 0)
		{
			response = "Effects of Adderall on the Body. For people diagnosed with attention-deficit hyperactivity disorder (ADHD), Adderall helps to improve concentration and focus. \n What else do you want to learn about- Mixing with other drugs?";

		}
		else if (findKeyword(statement, "3") >= 0)
		{
			response = "You have chosen adderall.\n  Do you want to learn about its Price or Side Effects?";

		}
		else if (findKeyword(statement, "Mixing") >= 0)
		{
			response = "You have chosen Mixing with other drugs.Which drugs did you mix adderall with? \n D. Alcohol E.Marijuana F.Xanax ";

		}
		else if (findKeyword(statement, "mixing") >= 0)
		{
			response = "You have chosen Mixing with other drugs.Which drugs did you mix adderall with? \n D. Alcohol E.Marijuana F.Xanax ";

		}
		else if (findKeyword(statement, "D") >= 0)
		{
			response = "You have chosen Mixing with Alcohol.  \n Adderall use can cause people to feel more sober than they truly are, and this might cause people to drink excessively because they can’t feel the effects of the alcohol they’ve drank.Do you also want to learn about Alcohol? ";
			if (statement == "yes") {
				response = "An alcoholic drink is a drink that contains ethanol, a type of alcohol produced by fermentation of grains, fruits, or other sources of sugar. Drinking alcohol plays an important social role in many cultures. ";
			}
		}
		else if (findKeyword(statement, "E") >= 0)
		{
			response = "You have chosen Mixing with Marijuana. \nUsing marijuana could decrease the chances of individuals knowing that they are experiencing harmful effects of taking too much Adderall. The reduction of inhibitions caused by marijuana could also cause people on Adderall to have decreased consideration for what could happen if other substances are taken. In addition, mixing the two can cause stress since Adderall could increase heartbeat while marijuana slows it down. \n Do you also want to learn about Marijuana?";
			if (statement == "yes") {
				response = "Cannabis, also known as marijuana among other names, is a psychoactive drug from the Cannabis plant used for medical or recreational purposes. The main psychoactive part of cannabis is tetrahydrocannabinol, one of 483 known compounds in the plant, including at least 65 other cannabinoids.";
			}
		}
		else if (findKeyword(statement, "F") >= 0)
		{
			response = "You have chosen Mixing with Xanax  \n Both Adderall and Xanax cause dependence and affect the central nervous system multiplies their potential side effects, severe symptoms, and risks. \n Do you also want to learn about Xanax?  ";
			if (statement == "yes") {
				response = "Xanax is a member of the benzodiazepine family of drugs and is primarily used to treat anxiety and panic disorders.Xanax works by increasing the amount of the neurotransmitter GABA in the brain to promote calmness and a relaxed feeling.";
			}
		}
		return response;
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Okay",
			"Hmmm.",
			"Hmph Yes?",
			"You don't say.",
			"Oh yes.",
			"Great",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"NO.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"Wavy", "Today is a good day", "Very Nice."};
	
}
