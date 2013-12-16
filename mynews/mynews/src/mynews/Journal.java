package mynews;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Journal {
	private String titre="ssss";
	private String description="ddd";
	private Date date ;
	private String author="aaaaa";
	private String copyright="cccc";
	private String source="sss";
	private String theme="sport";
	private String lien="www.google.com";
	public static String m="Wed Oct 23 23:09:51 CEST 2013";
	 public static void main( String[] args)
	 {
		 //Journal x=new Journal();
		 //x.SetDate(m);
	 }
	 
		public void SetDate(String l)  
		{
			  SimpleDateFormat f =   new SimpleDateFormat("EEEE, d MMMM yyyy HH:mm:ss", Locale.FRANCE); 
			  //DateFormat readFormat=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ROOT);
			  DateFormat writeFormat=new SimpleDateFormat("yyyy-MM-dd");
			  java.util.Date timeDate = null;
			  try {
			   timeDate = f.parse(l);
			  } catch (ParseException e) {
			   
			   e.printStackTrace();
			  }
			 // System.out.println(timeDate);
			  String SQLDate = "";
			    if( timeDate != null ) {
			    	SQLDate = writeFormat.format( timeDate );
			    }
			    java.sql.Date sqlDate=Date.valueOf(SQLDate) ;
			  //java.sql.Date sqlDate = new java.sql.Date(timeDate.getTime());
			this.date=sqlDate;
			
			
		}
	 
	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public java.util.Date getDate() {
		return date;
	}

	public String getAuthor() {
		return author;
	}

	public String getCopyRight() {
		return copyright;
	}
    public String getSource()
    {
    	return source;
    	
    }
    public String getTheme()
    {
    	return theme;
    	
    }
    public String getLien()
    {
    	return lien;
    	
    }
    
	@Override
	public String toString() {
		return "Journal [titre=" + getTitre() + ", date=" + getDate() + ", description="
				+ getDescription() + ", author=" + getAuthor() + ", copyright=" + getCopyRight() + ", source="+ getSource()+", theme="+ getTheme()+"]";
	
	
}

	public void SetTitre(String titre) {
		 String t=titre.replaceAll("'"," ");
		 
		this.titre = t;
	}

	public void SetDescription(String description) {
		this.description = description;
		
	}

	public void SetTheme(String theme) {
		
		this.theme=theme;
		
	}
	public void SetSource(String source) {
		String sou=source.replaceAll("'"," ");
		String sou2=sou.replaceAll("иж","e");
		this.source=sou2;
		
	}
	public void SetAuthor(String author) {
		this.author=author;
		
	}
	public void SetLien(String lien)
	 {
		this.lien=lien;
		
	}
	public void SetCopyRight(String copyright) {
		this.copyright=copyright;
		
	}

	
}
