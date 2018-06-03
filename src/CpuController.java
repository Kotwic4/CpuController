import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class CpuController {

    public static void main(String[] args) {
        try {
            String fileName = args[0];
            int cpuTemp = Integer.parseInt(args[1]);
            int fanSpeed = Integer.parseInt(args[2]);
            int fanMode = Integer.parseInt(args[3]);
            FIS fis = FIS.load(fileName, false);

            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

            fuzzyRuleSet.setVariable("cpu_temp", cpuTemp);
            fuzzyRuleSet.setVariable("fan_speed", fanSpeed);
            fuzzyRuleSet.setVariable("fan_mode", fanMode);

            fuzzyRuleSet.evaluate();

            fuzzyRuleSet.getVariable("fan_speed_change").chartDefuzzifier(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<cpu_temp> int<fan_speed> int<fan_mode>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<cpu_temp> int<fan_speed> int<fan_mode>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
