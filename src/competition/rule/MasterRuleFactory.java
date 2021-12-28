package competition.rule;

/**
 * @author diawara
 * @author abdoulkader
 */
public class MasterRuleFactory 
{
	public static MasterRule getMasterRule(int id)
	{
		switch (id) 
		{
			case 1:
				return new MasterRule16();
			case 2:
				return new MasterRule24();
			case 3:
				return new MasterRule4();
			default:
				return null;
		}
	}
}
