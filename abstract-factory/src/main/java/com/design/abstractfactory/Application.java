package com.design.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractFactory
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private Ship mShip;
    private Captain mCaptain;
    private Sailor mSailor;

    public void createTeam(final TeamFactory factory) {
        setmCaptain(factory.createCaptain());
        setmShip(factory.createShip());
        setmSailor(factory.createSailor());
    }

    public static void main(String[] args) {

        Application app = new Application();

        app.createTeam(new YoungTeamFactory());
        LOGGER.info("正在创建一支年轻的队伍...");
        LOGGER.info("-->" + app.getmCaptain().getDescription());
        LOGGER.info("-->" + app.getmShip().getDescription());
        LOGGER.info("-->" + app.getmSailor().getDescription());

        app.createTeam(new PermanentTeamFactory());
        LOGGER.info("正在创建一支久经考验的队伍...");
        LOGGER.info("-->" + app.getmCaptain().getDescription());
        LOGGER.info("-->" + app.getmShip().getDescription());
        LOGGER.info("-->" + app.getmSailor().getDescription());
    }

    public Ship getmShip() {
        return mShip;
    }

    public void setmShip(Ship mShip) {
        this.mShip = mShip;
    }

    public Captain getmCaptain() {
        return mCaptain;
    }

    public void setmCaptain(Captain mCaptain) {
        this.mCaptain = mCaptain;
    }

    public Sailor getmSailor() {
        return mSailor;
    }

    public void setmSailor(Sailor mSailor) {
        this.mSailor = mSailor;
    }
}