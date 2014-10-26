package tweets.cli;

import java.util.Scanner;

import tweets.business.App;

/**
 * Created by fa on 26/10/14.
 */
public class CommandLine {
	public static final String PROMPT = "Tweet >"; 
	public static final String INVALID_COMMAND = "Comando Invalido";
	public static final String[] COMMANDS ={"exit","moreMentioned","nearest"};
	public static final int ONE_ARGUMENT = 1;
	public static final int TWO_ARGUMENTS = 2;
	
	
	public static int wordCount(String s){
	    if (s == null)return 0;
	     return s.trim().split("\\s+").length;
	}
	
	public static String getArgument(String s, int a){
		if (s == null)return null;
		String []tmp = s.split(" "); 
		return tmp[a];
	}
	
	public static void cli(){
		Scanner in = new Scanner(System.in);
		String cmd;		
		
		boolean loop = true;
		while(loop){
			System.out.print(PROMPT);
			String fullcmd = in.nextLine();
			cmd = getArgument(fullcmd,0);
			
			
			switch(cmd){
			case "exit": loop = false;
						break;		
						
			case "moreMentioned": 					
				if( wordCount(fullcmd) == ONE_ARGUMENT)
					App.funcionalidade1(getArgument(fullcmd,1));
				else					
					App.funcionalidade2(
					Integer.parseInt(getArgument(fullcmd,1)),					
					ConvertDate.getInstant(getArgument(fullcmd,2)),
					ConvertDate.getInstant(getArgument(fullcmd,3)),
					getArgument(fullcmd,4));
					break;
					
			case "nearest":
				if( wordCount(fullcmd) == TWO_ARGUMENTS)
					App.funcionalidade3(
							Integer.parseInt(getArgument(fullcmd,1)),
							ConvertDate.getInstant(getArgument(fullcmd,2)));
				else					
					App.funcionalidade4(
					Integer.parseInt(getArgument(fullcmd,1)),					
					ConvertDate.getInstant(getArgument(fullcmd,2)),
					getArgument(fullcmd,3));
					break;
					
				default :
					System.out.println("["+cmd+"] " + INVALID_COMMAND);
				break;			
			}			
		}		
		in.close();
	}
}
