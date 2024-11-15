package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;

public class IntakeCommand extends Command {
    private ControlBoard control;
    private Intake intake;

    public IntakeCommand(ControlBoard control, Intake intake) {
        this.intake = intake;
        this.control = control;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (this.control.leftBumper()){
            this.intake.setSpeed(1);
        } else {
            this.intake.setSpeed(0);
        }
    }
}
