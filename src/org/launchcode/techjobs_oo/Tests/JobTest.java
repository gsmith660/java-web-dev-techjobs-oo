package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job emptyJob;
    Job testJob;
    Job partialJob;

    @Before
    public void initializeTwoJobs() {
        emptyJob = new Job();
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        partialJob = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType(), new CoreCompetency());
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
        assertEquals(1, Math.abs(job1.getId() - job2.getId()));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertTrue(job.getName() instanceof String);
//        assertTrue(job.getEmployer() instanceof Employer);
//        assertTrue(job.getLocation() instanceof Location);
//        assertTrue(job.getPositionType() instanceof PositionType);
//        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");
        Job job1 = new Job("Product tester", employer, location, positionType, coreCompetency);
        Job job2 = new Job("Product tester", employer, location, positionType, coreCompetency);
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobToStringBeginsAndEndsWithBlankLine() {
        String testString = testJob.toString();

        assertEquals('\n', testString.charAt(0));
        assertEquals('\n', testString.charAt(testString.length() - 1));
    }

    @Test
    public void testJobToStringAllFieldsDisplayed() {
        String testString = testJob.toString();
        String[] lines = testString.split("\n");
        assertEquals("ID: 2", lines[1]);
        assertEquals("Name: Product tester", lines[2]);
        assertEquals("Employer: ACME", lines[3]);
        assertEquals("Location: Desert", lines[4]);
        assertEquals("Position Type: Quality control", lines[5]);
        assertEquals("Core Competency: Persistence", lines[6]);
    }

    @Test
    public void testJobToStringEmptyFieldsDisplayedWithMessage() {
        String testString = partialJob.toString();
        String[] lines = testString.split("\n");
        assertEquals("ID: 3", lines[1]);
        assertEquals("Name: Product tester", lines[2]);
        assertEquals("Employer: ACME", lines[3]);
        assertEquals("Location: Data not available", lines[4]);
        assertEquals("Position Type: Data not available", lines[5]);
        assertEquals("Core Competency: Data not available", lines[6]);
    }


}
