package CSArmyBot.commands;

import CSArmyBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class SelfAssignCommand extends Command {

    public SelfAssignCommand() {
        this.name = "notify";
        this.category = main.NORMAL;
        this.guildOnly = true;
        this.arguments = "<Role>";
        this.help = "Assign your self a specific role to recive updates W.I.P";
        this.ownerCommand = true;
    }


    //TODO Make this better
    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty()) {
            event.replyError("You must supply a role!");
            return;
        }

        String[] args = event.getArgs().split(" ");
        args[0].toLowerCase();

        switch (args[0]) {
            case "pokedash": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokedash", true).get(0)).queue();
                break;
            }
            case "pokeverse": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokeverse", true).get(0)).queue();
                break;
            }
            case "pokelegends": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokelegends", true).get(0)).queue();
                break;
            }
            case "pokeclub": {
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("pokeclub", true).get(0)).queue();
                break;
            }
            default: {
                event.replyError("We do not support this role!");
                return;
            }
        }
        event.replySuccess("Successfully added " + args[0] + " tag!");
    }
}
