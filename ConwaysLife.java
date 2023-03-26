// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConwaysLife {
    public static void main(String[] args) {

        try {

            // This is boilerplate code.
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            TerminalSize size = screen.getTerminalSize();

            // We create the simulator.
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());

            // We insert a pattern here.
            System.out.println("The pattern is now running. Feel free to change " +
                    "which pattern runs by uncommenting the code on lines 26-29.");
            simulation.insertPattern(new PatternAcorn(), 20, 10);
            // simulation.insertPattern(new PatternBlock(), 20, 10);
            // simulation.insertPattern(new PatternBlinker(), 20, 10);
            // simulation.insertPattern(new PatternGlider(), 5, 5);

            // This is more boilerplate code.
            screen.startScreen();
            screen.setCursorPosition(null);

            // We enter a for loop.
            for (int i = 0; i < 200; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(100);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }
            // This stops the simulation.
            screen.stopScreen();
        }
        // This catches exceptions.
        catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }

    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {

        // We iterate through the x-values.
        for (int i = 0; i < simulation.getSizeX(); i++) {

            // We iterate through the y-values.
            for (int j = 0; j < simulation.getSizeY(); j++) {

                // If the value is true, we fill it in with X.
                if (simulation.patternArray[i][j]) {
                    graphics.setCharacter(i, j, 'X');
                }
                // Otherwise, we set a space.
                else {
                    graphics.setCharacter(i, j, ' ');
                }
            }
        }
        try {
            screen.refresh();
        }
        catch (Exception ignored) {
        }
    }
}