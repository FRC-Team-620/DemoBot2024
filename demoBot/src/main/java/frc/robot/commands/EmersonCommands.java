package frc.robot.commands;

import org.opencv.ml.EM;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.EmersonSubsystem;

public class EmersonCommands {
    
    private EmersonSubsystem emersonSubsystem;
    private CommandXboxController control = new CommandXboxController(0);
    public EmersonCommands(EmersonSubsystem emersonSubsystem, CommandXboxController control){
        this.emersonSubsystem = emersonSubsystem;
        this.control = control;
        addRequirements(emersonSubsystem);
    }
}
