package com.usmanshahid.jflapcli.grammar;

import java.util.ArrayList;
import java.util.Set;

import edu.duke.cs.jflap.automata.vdg.VariableDependencyGraph;
import edu.duke.cs.jflap.grammar.CNFConverter;
import edu.duke.cs.jflap.grammar.Grammar;
import edu.duke.cs.jflap.grammar.LambdaProductionRemover;
import edu.duke.cs.jflap.grammar.Production;
import edu.duke.cs.jflap.grammar.UnitProductionRemover;
import edu.duke.cs.jflap.grammar.UnrestrictedGrammar;
import edu.duke.cs.jflap.grammar.UselessProductionRemover;
import edu.duke.cs.jflap.grammar.parse.CYKParser;

public class GrammarTester {
    // The Grammar that is going to be transformed into CNF
    protected Grammar myGrammar;

    private ArrayList <Production> myTempCNF;

    private String START_SYMBOL_MESSAGE = "START_DERIVES_LAMBDA";
    private String NO_TERMINALS_MESSAGE = "HAS_NO_TERMINALS";

    // Constructor
    public GrammarTester(Grammar g) {
        myGrammar = g;
    }


    public boolean canGenerate(String input){
        if (myGrammar == null){
            throw new RuntimeException("Invalid grammar, grammar is null");
        }

        if(myGrammar.getTerminals().length==0) {
            return false;
        }

        Grammar cnf;
        try {
            cnf = convertCNF(input);
        } catch (RuntimeException ex){
            if(ex.getMessage() == START_SYMBOL_MESSAGE){
                return true;
            }
            if(ex.getMessage() == NO_TERMINALS_MESSAGE){
                return false;
            }
            throw ex;
        }
        CYKParser parser = new CYKParser(cnf);
        return parser.solve(input);
    }

    // function to convert grammar to CNF
    public Grammar convertCNF(String input){
        
        // Remove lambda productions
        LambdaProductionRemover lambdaRemover = new LambdaProductionRemover();
        Set lambdaDerivers = lambdaRemover.getCompleteLambdaSet(myGrammar);
        if (lambdaDerivers.contains(myGrammar.getStartVariable()) && input.isEmpty()) {
            throw new RuntimeException(START_SYMBOL_MESSAGE);
        }

        // Remove lambda
        Grammar g = lambdaRemover.getLambdaProductionlessGrammar(myGrammar, lambdaDerivers);

        // Remove Unit
        UnitProductionRemover unitRemover = new UnitProductionRemover();
        VariableDependencyGraph vdg = unitRemover.getVariableDependencyGraph(g);
        g  = unitRemover.getUnitProductionlessGrammar(g, vdg);

        // Remove useless
        g = UselessProductionRemover.getUselessProductionlessGrammar(g);

        if (g.getTerminals().length == 0) {
            throw new RuntimeException(NO_TERMINALS_MESSAGE);
        }

        // Convert chomsky and return
        Grammar ug = getCNF(g);
        return ug;
    }

    /**
     * Method for finalizing Chomsky form
     * @param env Our grammar environment
     * @param g Grammar in transformation
     */
    protected Grammar getCNF(Grammar g) {
        //System.out.println("Chomsky TIME");
        
        CNFConverter converter = null;
        try {
            converter = new CNFConverter(g);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal Grammar");
        }
        Production[] p = g.getProductions();
        boolean chomsky = true;
        for (int i = 0; i < p.length; i++)
            chomsky &= converter.isChomsky(p[i]);
        
        if (!chomsky) {
            ArrayList <Production> resultList=new ArrayList <Production>();
            for (int i=0; i<p.length; i++)
            {
                myTempCNF=new ArrayList <Production>();
                converter = new CNFConverter(g);
                convertToCNF(converter, p[i]);
                resultList.addAll(myTempCNF);
            }
            Production[] pp=new Production[resultList.size()];
            for (int i=0; i<pp.length; i++)
            {
                pp[i]=resultList.get(i);
            }
            pp=converter.convert(pp);
            String var=g.getStartVariable();
            g=new UnrestrictedGrammar();
            g.addProductions(pp);
            g.setStartVariable(var);
            
        }
        return g;
    }
    
    private void convertToCNF(CNFConverter converter, Production p)
    {
        if (!converter.isChomsky(p))
        {
            Production temp[]=converter.replacements(p);
            for (int j=0; j<temp.length; j++)
            {
                p=temp[j];
                convertToCNF(converter, p);
            }
        }	
        else
            myTempCNF.add(p);
    }
}
