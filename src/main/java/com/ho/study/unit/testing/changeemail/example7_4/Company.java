package com.ho.study.unit.testing.changeemail.example7_4;

public class Company {
    
    private String domainName;
    private Integer numberOfEmployees;

    public Company(String domainName, Integer numberOfEmployees) {
        this.domainName = domainName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public void changeNumberOfEMployees(Integer delta) {
        Precondition.requires(this.numberOfEmployees + delta >= 0);

        this.numberOfEmployees += delta;
    }

    public Boolean isEmailCorporate(String email) {
        String emailDomain = email.split("@")[1];
        return emailDomain.equals(this.domainName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domainName == null) ? 0 : domainName.hashCode());
        result = prime * result + ((numberOfEmployees == null) ? 0 : numberOfEmployees.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        if (domainName == null) {
            if (other.domainName != null)
                return false;
        } else if (!domainName.equals(other.domainName))
            return false;
        if (numberOfEmployees == null) {
            if (other.numberOfEmployees != null)
                return false;
        } else if (!numberOfEmployees.equals(other.numberOfEmployees))
            return false;
        return true;
    }
}
