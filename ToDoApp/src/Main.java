public class Main {

    public static void main(String[] args) {
        Interaction interaction = new Interaction();

        boolean go = true;
        while (go){
            int number = interaction.selectOption();
            switch (number){
                case 1:
                    interaction.printMap();
                    break;
                case 2:
                    interaction.addNewTask();
                    break;
                case 3:
                    interaction.delete();
                    break;
                case 4:
                    interaction.updateTask();
                case 0:
                    return;
                default:
                    continue;
            }
        }
    }
}
