package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.AndrewSubsystem;
import frc.robot.subsystems.Drivetrain;

public class AndrewCommand extends Command {
    private AndrewSubsystem drivetrain;
    private CommandXboxController control = new CommandXboxController(0);

    public AndrewCommand(AndrewSubsystem drivetrain, CommandXboxController control){
        this.drivetrain = drivetrain;
        this.control = control;

        addRequirements(drivetrain);
    }

}
