package frc.robot.subsystems;

// import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    // we should also declare/initiate the gyro here to set up our robot odometry
    private CANSparkMax leftFront = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax rightFront = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax leftRear = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rightRear = new CANSparkMax(4, MotorType.kBrushless);

    private DifferentialDrive diffDrive;
    private double speed;
    private double rotation;
    private boolean quickTurn;

    private RelativeEncoder leftFrontEncoder;
    private RelativeEncoder leftRearEncoder;
    private RelativeEncoder rightFrontEncoder;
    private RelativeEncoder rightRearEncoder;

    public Drivetrain (){
        initMotor(leftFront);
        initMotor(leftRear);
        initMotor(rightFront);
        initMotor(rightRear);

        setFollowers();

        leftFrontEncoder = this.leftFront.getEncoder();
		rightFrontEncoder = this.rightFront.getEncoder();
		leftRearEncoder = this.leftRear.getEncoder();
		rightRearEncoder = this.rightRear.getEncoder();

        diffDrive = new DifferentialDrive(rightFront, leftFront);
        // this line down here sets up the robot odometry; the DifferentialDriveOdometry takes three arguments: rotation(rotation2d, left encoder reading and right encoder reading
        //odometry = new DifferentialDriveOdometry(this.getRotation2d, this.leftFrontEncoder.getPosition(), this.rightFrontEncoder.getPositiobn());
    }

    private void initMotor(CANSparkMax motor){
        motor.setOpenLoopRampRate(20);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(40);
    }

    private void setFollowers(){
        leftRear.follow(leftFront);
        rightRear.follow(rightFront);
    }

    // public Rotation2d getRotation2d(){
        // double degrees = -MathUtil.inputModulus(this.pigeon.getYaw(), -180, 180);
    //     return Rotation2d.fromDegrees(degrees);
    // }

    // public Pose2d getPose2d(){
    //     return this.odometry.getPose2d();
    // }
    
    public void setCurvitureDrive(double speed, double rotation, boolean quickTurn){
        this.speed = speed;
        this.rotation = rotation;
        this.quickTurn = quickTurn;
    }

    @Override
    public void periodic() {
        diffDrive.curvatureDrive(speed, rotation, quickTurn);
        System.out.println("Speed: " + speed);
    }
}
