/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
package org.jboss.esb;

import java.util.Map;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class CustomAction extends AbstractActionLifecycle {

	protected ConfigTree _config;

	public CustomAction(final ConfigTree config) {
		_config = config;
	}

	public Message noOperation(final Message message) {
		return message;
	}

	@SuppressWarnings("unchecked")
	public Message displayMessage(final Message message) throws Exception {
		logHeader();
		final Map<String, Object> rowData = (Map) message.getBody().get();
		final StringBuffer results = new StringBuffer();
		for (final Map.Entry<String, Object> curr : rowData.entrySet()) {
			results.append("column " + curr.getKey() + " = <" + curr.getValue() + ">");
		}
		System.out.println(results.toString());
		logFooter();

		// Set message properties and message body so that SystemPrintln will display message
		message.getProperties().setProperty("jbesbfilename", "helloworldSQlAction.log");
		message.getBody().add(results.toString());
		return message;
	}

	private final String HEADER_LINE = "\n*********************************************";

	private void logHeader() {
		System.out.println(HEADER_LINE);
	}

	private void logFooter() {
		System.out.println(HEADER_LINE);
	}

}
