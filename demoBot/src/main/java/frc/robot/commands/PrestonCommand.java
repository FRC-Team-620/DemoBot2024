package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.PrestonSubsystem;

public class PrestonCommand extends Command {
    private PrestonSubsystem prestonSubsystem;
    private final CommandXboxController control = new CommandXboxController(0);

    public PrestonCommand(CommandXboxController control, PrestonSubsystem prestonSubsystem) {
        this.prestonSubsystem = prestonSubsystem;
        this.control = control;

        addRequirements(prestonSubsystem);
    }

    @Override
    public void execute() {
        prestonSubsystem.setSpeed(20.0);
    }
}
