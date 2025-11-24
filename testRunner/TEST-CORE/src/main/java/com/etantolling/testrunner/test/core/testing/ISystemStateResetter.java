package com.etantolling.testrunner.test.core.testing;

import java.sql.SQLException;

public interface ISystemStateResetter {
	public void resetState() throws SQLException;
}
