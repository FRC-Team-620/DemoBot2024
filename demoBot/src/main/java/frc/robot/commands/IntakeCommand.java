package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;
public class IntakeCommand extends Command{
    private Intake intake;
    private ControlBoard control;

    public IntakeCommand(ControlBoard control, Intake intake){
        this.control = control;
        this.intake = intake;
    }

}
