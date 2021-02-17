package org.politecnico;

import com.opencsv.CSVParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

CSVParser csvParser = new CSVParser();

    public CSVParser getCsvParser() {
    csvParser.getEscape();
        return csvParser;

    }
}
