public class HangmanDrawing {
    public static void drawHangman(int errorCount) {
        switch (errorCount) {
            case 0:
                System.out.println("""
                    
                    
                    
                    
                    
                   
                    ________________
                    """);
                break;
            case 1:
                System.out.println("""
                    
                     |
                     |
                     |
                     |
                     |
                    _|_______________
                    """);
                break;
            case 2:
                System.out.println("""
                      _________
                     |
                     |
                     |
                     |
                     |
                    _|_______________
                    """);
                break;
            case 3:
                System.out.println("""
                     __________
                     |        |
                     |
                     |
                     |
                     |
                    _|_______________
                    """);
                break;
            case 4:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |        
                     |
                     |
                    _|_______________
                    """);
                break;
            case 5:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |        |
                     |
                     |
                    _|_______________
                    """);
                break;
            case 6:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |       /|
                     |
                     |
                    _|_______________
                    """);
                break;
            case 7:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |       /|\\
                     |
                     |
                    _|_______________
                    """);
                break;
            case 8:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |       /|\\
                     |       /
                     |
                    _|_______________
                    """);
                break;
            case 9:
                System.out.println("""
                     __________
                     |        |
                     |        ○
                     |       /|\\
                     |       / \\
                     |
                    _|_______________
                    """);
                break;
        }
    }
}
