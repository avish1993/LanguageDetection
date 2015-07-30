import java.io.*;
import java.util.Arrays;

import javax.servlet.http.Part;
public class AcceptInp {
	
	static String langname[]=new String[17];	//i've worked on 17 languages, change this to include more languages
	AcceptInp()
	{
		langname[0]="English";	//language names stored in the array
		langname[1]="Arabic";	//please change these to ISO 639-1 standards if required
		langname[2]="Hindi";
		langname[3]="Bengali";
		langname[4]="Gurmukhi";
		langname[5]="Gujarati";
		langname[6]="Oriya";
		langname[7]="Tamil";
		langname[8]="Telegu";
		langname[9]="Kannada";
		langname[10]="Malayalam";
		langname[11]="Sinhala";
		langname[12]="Thai";
		langname[13]="Lao";
		langname[14]="Tibetian";
		langname[15]="Mynamar";
		langname[16]="Mongolian";
	}

	/*
	 * this function returns the language statistics of the file uploaded
	 */
    public static String stats(Part filePart) throws IOException {	
		// TODO Auto-generated method stub
    	int list[]=new int[17];		//stores the corresponding languages' character count details 
    	String ret="";
        try {
        	InputStream fileContent = filePart.getInputStream();
    	    InputStreamReader inp=new InputStreamReader(fileContent);
    	    BufferedReader in = new BufferedReader(inp);
    	    String str;
            while ((str = in.readLine()) != null) {
            	for(int i=0;i<str.length();i++)		//processing the file, can be improvised
            	{
            		char ch = str.charAt(i);
            		// The unicode range for different languages can be obtained from the following lines
            		if((ch >= 0x0041 && ch <= 0x024F))				//english
            			{list[0]++; langname[0] = "English";}
            		else if(ch >= 0x0600 && ch <= 0x06FF)		//arabic
            			{list[1]++; langname[1] = "Arabic";}
            		else if(ch >= 0x0900 && ch <= 0x097F)		//hindi //devangiri
            			{list[2]++;  langname[2] = "Hindi";}
            		else if(ch >= 0x0980 && ch <= 0x09FF)			//bengali
            			{list[3]++;  langname[3] = "Bengali";}
            		else if(ch >= 0x0A00 && ch <= 0x0A7F)		//gurmukhi
            			{list[4]++; langname[4] = "Gurmukhi";}
            		else if(ch >= 0x0A80 && ch <= 0x0AFF)		//gujarati
            			{list[5]++;langname[5] = "Gujarati";}            		
            		else if(ch >= 0x0B00 && ch <= 0x0B7F)		//oriya
            			{list[6]++;langname[6] = "Oriya";}
            		else if(ch >= 0x0B80 && ch <= 0x0BFF)		//tamil
            			{list[7]++;langname[7] = "Tamil";}
            		else if(ch >= 0x0C00 && ch <= 0x0C7F)		//telegu
            			{list[8]++;langname[8] = "Telegu";}
            		else if(ch >= 0x0C80 && ch <= 0x0CFF)		//kannada
            			{list[9]++;langname[9] = "Kannada";}
            		else if(ch >= 0x0D00 && ch <= 0x0D7F)		//malayalam
            			{list[10]++;langname[10] = "Malayalam";}
            		else if(ch >= 0x0D80 && ch <= 0x0DFF)		//sinhala
            			{list[11]++;langname[11] = "Sinhala";}
            		else if(ch >= 0x0E00 && ch <= 0x0E7F)		//thai
            			{list[12]++;langname[12] = "Thai";}
            		else if(ch >= 0x0E80 && ch <= 0x0EFF)		//lao
            			{list[13]++;langname[13] = "Lao";}
            		else if(ch >= 0x0F00 && ch <= 0x0FFF)		//tibetian
            			{list[14]++;langname[14] = "Tibetian";}
            		else if(ch >= 0x1000 && ch <= 0x109F)		//mynamar
            			{list[15]++;langname[15] = "Mynamar";}
            		else if(ch >= 0x1800 && ch <= 0x18AF)		//mongolian
            			{list[16]++;langname[16] = "Mongolian";}
            		
            	}
            }
            in.close();
        }
        catch (IOException e) {
        }
        int p[]=new int[17];
        for(int k=0; k<17;k++)
        	p[k]=list[k];
        Arrays.sort(p);
        int k=0;
        for(int i:list)
        	if(i == p[16])
        		break;
        	else
        		k=k+1;
        k=0;
        for(k=0;k<17;k++)
        	if(list[k]!=0)
        		ret = ret +" "+ langname[k]+ " "+ list[k];
        return ret;		//returning the statistics of the entered file
	}
    
    public static String phraselang(String str)
    {
    	int list[]=new int[17];			//stores the corresponding languages' character count details 
    	String ret="";        
    	try {
            	for(int i=0;i<str.length();i++)
            	{
            		char ch = str.charAt(i);		//processing the file, can be improvised
            		// The unicode range for different languages can be obtained from the following lines
            		if((ch >= 0x0041 && ch <= 0x024F))				//english
            			{list[0]++; langname[0] = "English";}
            		else if(ch >= 0x0600 && ch <= 0x06FF)		//arabic
            			{list[1]++; langname[1] = "Arabic";}
            		else if(ch >= 0x0900 && ch <= 0x097F)		//hindi //devangiri
            			{list[2]++;  langname[2] = "Hindi";}
            		else if(ch >= 0x0980 && ch <= 0x09FF)			//bengali
            			{list[3]++;  langname[3] = "Bengali";}
            		else if(ch >= 0x0A00 && ch <= 0x0A7F)		//gurmukhi
            			{list[4]++; langname[4] = "Gurmukhi";}
            		else if(ch >= 0x0A80 && ch <= 0x0AFF)		//gujarati
            			{list[5]++;langname[5] = "Gujarati";}            		
            		else if(ch >= 0x0B00 && ch <= 0x0B7F)		//oriya
            			{list[6]++;langname[6] = "Oriya";}
            		else if(ch >= 0x0B80 && ch <= 0x0BFF)		//tamil
            			{list[7]++;langname[7] = "Tamil";}
            		else if(ch >= 0x0C00 && ch <= 0x0C7F)		//telegu
            			{list[8]++;langname[8] = "Telegu";}
            		else if(ch >= 0x0C80 && ch <= 0x0CFF)		//kannada
            			{list[9]++;langname[9] = "Kannada";}
            		else if(ch >= 0x0D00 && ch <= 0x0D7F)		//malayalam
            			{list[10]++;langname[10] = "Malayalam";}
            		else if(ch >= 0x0D80 && ch <= 0x0DFF)		//sinhala
            			{list[11]++;langname[11] = "Sinhala";}
            		else if(ch >= 0x0E00 && ch <= 0x0E7F)		//thai
            			{list[12]++;langname[12] = "Thai";}
            		else if(ch >= 0x0E80 && ch <= 0x0EFF)		//lao
            			{list[13]++;langname[13] = "Lao";}
            		else if(ch >= 0x0F00 && ch <= 0x0FFF)		//tibetian
            			{list[14]++;langname[14] = "Tibetian";}
            		else if(ch >= 0x1000 && ch <= 0x109F)		//mynamar
            			{list[15]++;langname[15] = "Mynamar";}
            		else if(ch >= 0x1800 && ch <= 0x18AF)		//mongolian
            			{list[16]++;langname[16] = "Mongolian";}
            		
            	}
        }
        catch (Exception e) {
        }
        int p[]=new int[17];
        for(int k=0; k<17;k++)
        	p[k]=list[k];
        Arrays.sort(p);
        int k=0;
        for(int i:list)
        	if(i == p[16])
        		break;
        	else
        		k=k+1;
        k=0;
        for(k=0;k<17;k++)
        	if(list[k]!=0)
        		ret = ret +" "+ langname[k]+ " "+ list[k];
        return ret;		//returning the statistics of the entered file
    }
    public static int count1(Part filePart)		// returns character count of the whole file
    {
    	int c=0;
    	try {
        	InputStream fileContent = filePart.getInputStream();
    	    InputStreamReader inp=new InputStreamReader(fileContent);
    	    BufferedReader in = new BufferedReader(inp);
    	    String str;
            while ((str = in.readLine()) != null)
            	c+=str.length();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Do nothing.");
    	}
    	
    	
    	return c;
    }
    public static int count2(String str)	//returns the character count of the entered phrase
    {
    	int c=0;
    	try {
            	c=str.length();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Do nothing.");
    	}
    	return c;
    }
    

}
